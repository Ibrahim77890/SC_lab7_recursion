package com.example.mk4;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class StringPermutationsTest {

    @Test
    public void testGeneratePermutationsWithUniqueCharacters() {
        String input = "abc";
        List<String> result = StringPermutations.generatePermutations(input);
        assertEquals(6, result.size()); // 3! = 6
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));
    }

    @Test
    public void testGeneratePermutationsWithDuplicateCharacters() {
        String input = "aab";
        List<String> result = StringPermutations.generateUniquePermutations(input);
        assertEquals(3, result.size()); // 3 unique permutations: "aab", "aba", "baa"
        assertTrue(result.contains("aab"));
        assertTrue(result.contains("aba"));
        assertTrue(result.contains("baa"));
    }

    @Test
    public void testGeneratePermutationsWithEmptyString() {
        String input = "";
        List<String> result = StringPermutations.generatePermutations(input);
        assertEquals(1, result.size()); // 1 permutation: the empty string
        assertTrue(result.contains(""));
    }

    @Test
    public void testGeneratePermutationsWithSingleCharacter() {
        String input = "x";
        List<String> result = StringPermutations.generatePermutations(input);
        assertEquals(1, result.size()); // 1 permutation: "x"
        assertTrue(result.contains("x"));
    }

    @Test
    public void testGenerateUniquePermutationsWithSingleDuplicateCharacter() {
        String input = "aaa";
        List<String> result = StringPermutations.generateUniquePermutations(input);
        assertEquals(1, result.size()); // Only one unique permutation: "aaa"
        assertTrue(result.contains("aaa"));
    }

    @Test
    public void testNonRecursivePermutations() {
        String input = "abc";
        List<String> result = StringPermutations.generateNonRecursivePermutations(input);
        assertEquals(6, result.size()); // 3! = 6
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));
    }

    @Test
    public void testNonRecursivePermutationsWithDuplicates() {
        String input = "aab";
        List<String> result = StringPermutations.generateNonRecursivePermutations(input);
        assertEquals(6, result.size()); // There are 6 generated, but only 3 unique: "aab", "aba", "baa"
        assertTrue(result.contains("aab"));
        assertTrue(result.contains("aba"));
        assertTrue(result.contains("baa"));
    }
}
