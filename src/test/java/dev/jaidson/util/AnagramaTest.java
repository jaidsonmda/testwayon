package dev.jaidson.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramaTest {

    @Test
    void testNullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Anagrama.gerarAnagramasPossiveis(null));
        assertEquals("Entrada inválida!", exception.getMessage());
    }

    @Test
    void testEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Anagrama.gerarAnagramasPossiveis(""));
        assertEquals("Entrada inválida!", exception.getMessage());
    }

    @Test
    void testNonAlphabeticCharacters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Anagrama.gerarAnagramasPossiveis("abc123"));
        assertEquals("Entrada inválida!", exception.getMessage());
    }

    @Test
    void testSingleCharacter() {
        List<String> anagramas = Anagrama.gerarAnagramasPossiveis("a");
        assertEquals(1, anagramas.size());
        assertTrue(anagramas.contains("a"));
    }

    @Test
    void testTwoCharacters() {
        List<String> anagramas = Anagrama.gerarAnagramasPossiveis("ab");
        assertEquals(2, anagramas.size());
        assertTrue(anagramas.contains("ab"));
        assertTrue(anagramas.contains("ba"));
    }

    @Test
    void testThreeCharacters() {
        List<String> anagramas = Anagrama.gerarAnagramasPossiveis("abc");
        assertEquals(6, anagramas.size());
        assertTrue(anagramas.contains("abc"));
        assertTrue(anagramas.contains("acb"));
        assertTrue(anagramas.contains("bac"));
        assertTrue(anagramas.contains("bca"));
        assertTrue(anagramas.contains("cab"));
        assertTrue(anagramas.contains("cba"));
    }
}