package dev.jaidson.domain;

import dev.jaidson.interfaces.Navegador;

public class AdapterFirefox implements Navegador {
    @Override
    public String getEngine(String engine) {
        return "";
    }
}
