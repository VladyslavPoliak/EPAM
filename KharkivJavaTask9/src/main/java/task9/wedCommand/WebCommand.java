package task9.wedCommand;

import java.io.PrintWriter;

public interface WebCommand {

    void doCommand(String request, Object serverType, PrintWriter out);

}
