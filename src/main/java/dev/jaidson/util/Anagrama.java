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
    /**
     * Método recursivo para gerar todas as permutações possíveis de uma string.
     *
     * @param prefixo Parte do anagrama já montada.
     * @param letrasRestantes Letras ainda disponíveis para combinar.
     * @param resultado Lista onde os anagramas gerados serão armazenados.
     */
    private static void gerarPermutacoes(String prefixo, String letrasRestantes, List<String> resultado) {
        // Se não há mais caracteres para permutar, adiciona o anagrama à lista.
        if (letrasRestantes.isEmpty()) {
            resultado.add(prefixo);
        } else {
            // Percorre cada letra disponível e a adiciona ao prefixo, chamando a recursão para as letras restantes.
            for (int i = 0; i < letrasRestantes.length(); i++) {
                gerarPermutacoes(prefixo + letrasRestantes.charAt(i),
                        letrasRestantes.substring(0, i) + letrasRestantes.substring(i + 1),
                        resultado);
            }
        }
    }
}
