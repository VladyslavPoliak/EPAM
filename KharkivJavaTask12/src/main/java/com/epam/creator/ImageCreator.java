package com.epam.creator;

import com.epam.utils.Constants;

import javax.servlet.http.Part;
import java.io.*;

public class ImageCreator {
    public void loadAndSaveImage(Part filePart) throws IOException {
        final String fileName = getFileName(filePart);
        System.out.println(fileName);
        try (OutputStream out = new FileOutputStream(new File(Constants.STORAGE_FOLDER_PATH + File.separator
                + fileName));
             InputStream fileContent = filePart.getInputStream()) {
            int read;
            int bufferSize = 1024;
            final byte[] bytes = new byte[bufferSize];
            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        }
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
}
