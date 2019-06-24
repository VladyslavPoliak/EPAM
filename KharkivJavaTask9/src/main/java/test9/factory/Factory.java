package test9.factory;

import test9.Http;
import test9.Tcp;

public interface Factory {

    Http getHttp();
    Tcp getTcp();

}
