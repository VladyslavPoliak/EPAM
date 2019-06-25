package task9.handler.impl;

import task9.RunCommand;
import task9.factory.Factory;
import task9.handler.Handler;

public class GetNameHandler extends Handler {

    public GetNameHandler(Factory factory) {
        super(factory);
    }

    @Override
    public String doCommand(String request) {
        RunCommand runCommand = factory.getName();
        return runCommand.doCommand(request);
    }
}
