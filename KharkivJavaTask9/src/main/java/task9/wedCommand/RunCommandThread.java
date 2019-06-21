package task9.wedCommand;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class RunCommandThread implements Runnable {

    private WebCommand webCommand;
    private Socket socket;
    private String parameter;
    private Object serverType;

    public RunCommandThread(WebCommand webCommand, Socket socket, String parameter, Object serverType) {
        this.webCommand = webCommand;
        this.socket = socket;
        this.parameter = parameter;
        this.serverType = serverType;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            webCommand.doCommand(parameter, serverType, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
