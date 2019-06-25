package task9.handler.impl;

import task9.RunCommand;
import task9.factory.Factory;
import task9.handler.Handler;

public class GetCountHandler extends Handler {

    public GetCountHandler(Factory factory) {
        super(factory);
    }

    @Override
    public String doCommand(String request) {
        RunCommand runCommand = factory.getCount();
        return runCommand.doCommand(null);
    }
}
