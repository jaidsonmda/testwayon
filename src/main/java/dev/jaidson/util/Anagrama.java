package dev.jaidson.util;

import java.util.ArrayList;
import java.util.List;

public class Anagrama {
    
    public static List<String> gerarAnagramasPossiveis(String palavra) {
        if (palavra == null || palavra.isEmpty() || !palavra.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Entrada inválida!");
        }
        List<String> anagramasPossiveis = new ArrayList<>();
        gerarPermutacoes("",palavra,anagramasPossiveis);

        return anagramasPossiveis;

    }
    //
    private static void gerarPermutacoes(String prefixo, String letrasRestantes, List<String> resultado) {
        if (letrasRestantes.isEmpty()) {
            resultado.add(prefixo);
        } else {
            for (int i = 0; i < letrasRestantes.length(); i++) {
                gerarPermutacoes(prefixo + letrasRestantes.charAt(i),
                        letrasRestantes.substring(0, i) + letrasRestantes.substring(i + 1),
                        resultado);
            }
        }
    }
}
