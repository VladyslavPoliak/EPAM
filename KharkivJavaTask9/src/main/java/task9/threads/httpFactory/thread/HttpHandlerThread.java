package task9.threads.httpFactory.thread;

import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;
import task9.container.WebCommandManager;
import task9.server.AbstractCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpHandlerThread extends Thread {

    private Socket socket;
    private Map<String, AbstractCommand> commandMap;

    public HttpHandlerThread(Socket socket, TransportService transportService) {
        this.socket = socket;
        commandMap = new WebCommandManager(transportService).initWebCommandMap();
    }

    @Override
    public void run() {
        try {
            getInfo();
        } catch (IOException e) {
            System.out.println("Something is wrong");
        }
    }

    private void getInfo() throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream writer = socket.getOutputStream();
            startProcessRequest(reader.readLine(), writer);
        }
    }

    private void startProcessRequest(String request, OutputStream writer) throws IOException {
        System.out.println(request);
        if (request.startsWith(Constants.START_REQUEST)) {
            writer.write(Constants.HTTP_CODE_200.getBytes());
            writer.write(Constants.SEPARATOR.getBytes());
            String s = getCommandFromMap(request)
                    .doCommand(String.valueOf(getParametersFromRequest(request)));
            String result = Constants.RESPONSE_HEADER + s;
            writer.write(result.getBytes());
            writer.flush();
        } else {
            System.out.println("Wrong command");
        }
    }

    private int getParametersFromRequest(String request) {
        Matcher matcher = Pattern.compile(Constants.GET_ITEM_REQUEST_REGEXP).matcher(request);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    private AbstractCommand getCommandFromMap(String key) {
        Optional<String> optional = commandMap.keySet().stream()
                .filter(key::matches)
                .findFirst();
        return commandMap.get(optional.orElse(null));
    }
}
