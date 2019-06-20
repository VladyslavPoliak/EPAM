package task9.wedCommand;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class RunCommandThread implements Runnable {

    private WebCommand webCommand;
    private Socket socket;
    private String parameter;

    public RunCommandThread(WebCommand webCommand, Socket socket, String parameter) {
        this.webCommand = webCommand;
        this.socket = socket;
        this.parameter = parameter;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            out.println("HTTP/1.1 200 OK");
            out.println("Server: Java HTTP Server from SSaurel : 1.0");
            out.println("Date: " + new Date());
            out.println();
            out.println(webCommand.doCommand(parameter));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
