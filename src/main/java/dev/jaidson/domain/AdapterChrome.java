package dev.jaidson.domain;

import dev.jaidson.interfaces.Navegador;

public class AdapterChrome implements Navegador {
    @Override
    public String getEngine(String engine) {
        return "";
    }
}
