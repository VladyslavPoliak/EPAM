package task9.handler;

import task9.RunCommand;
import task9.factory.Factory;

public abstract class Handler implements RunCommand {

    protected Factory factory;

    public Handler(Factory factory) {
        this.factory = factory;
    }
}
