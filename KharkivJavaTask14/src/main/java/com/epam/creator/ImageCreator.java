package com.epam.creator;

import javax.servlet.http.Part;
import java.io.*;
import java.util.Objects;

public class ImageCreator {

    private String fileNameForSpecificUser;
    private String storageFolderPath;
    private String defaultAvatarPath;

    public ImageCreator(String storageFolderPath, String defaultAvatarPath) {
        this.storageFolderPath = storageFolderPath;
        this.defaultAvatarPath = defaultAvatarPath;
    }

    public void loadAndSaveImage(Part filePart, String userName) throws IOException {
        String fileName = getFileName(filePart);
        fileNameForSpecificUser = setNewFileName(fileName, userName);

        try (OutputStream out = new FileOutputStream(new File(storageFolderPath + File.separator
                + fileNameForSpecificUser));
             InputStream fileContent = setAvatar(fileName, filePart)) {
            int read;
            int bufferSize = 1024;
            final byte[] bytes = new byte[bufferSize];
            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        }
    }

    public String getFileNameForSpecificUser() {
        return fileNameForSpecificUser;
    }

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;
    }

    private InputStream setAvatar(String fileName, Part filePart) throws IOException {
        if (isUserNoSetAvatar(fileName)) {
            File file = new File(defaultAvatarPath);
            return new FileInputStream(file);
        }
        return filePart.getInputStream();
    }

    private String setNewFileName(String fileName, String userName) {
        if (isUserNoSetAvatar(fileName)) {
            return userName + defaultAvatarPath.substring(defaultAvatarPath.lastIndexOf("."));
        }
        return userName + Objects.requireNonNull(fileName).substring(fileName.lastIndexOf("."));
    }

    private boolean isUserNoSetAvatar(String fileName) {
        return fileName.equals("");
    }
}
