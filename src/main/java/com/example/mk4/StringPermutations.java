package com.example.mk4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StringPermutations {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string to generate its permutations:");
            String input = scanner.nextLine();

            System.out.println("Include duplicate permutations? (yes/no):");
            String includeDuplicates = scanner.nextLine();

            List<String> permutations;

            // Generate permutations based on user preference
            if (includeDuplicates.equalsIgnoreCase("yes")) {
                permutations = generatePermutations(input);
            } else {
                permutations = generateUniquePermutations(input);
            }

            // Display results
            System.out.println("Generated Permutations:");
            for (String perm : permutations) {
                System.out.println(perm);
            }
        }
    }

    // Recursive function to generate all permutations
    public static List<String> generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        generatePermutationsHelper("", str, result);
        return result;
    }

    // Helper method for generating permutations
    private static void generatePermutationsHelper(String prefix, String remaining, List<String> result) {
        int n = remaining.length();
        if (n == 0) {
            result.add(prefix); // Base case: add the current permutation to the result
        } else {
            for (int i = 0; i < n; i++) {
                // Choose a character and generate permutations for the remaining characters
                generatePermutationsHelper(prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1, n), result);
            }
        }
    }

    // Main method to generate unique permutations
    public static List<String> generateUniquePermutations(String str) {
        Set<String> uniquePermutations = new HashSet<>();
        generatePermutationsHelper("", str, uniquePermutations);
        return new ArrayList<>(uniquePermutations); // Convert Set to List when returning
    }

    // Helper method for generating permutations
    private static void generatePermutationsHelper(String prefix, String remaining, Set<String> uniquePermutations) {
        int n = remaining.length();
        if (n == 0) {
            uniquePermutations.add(prefix); // Add the permutation to the set
        } else {
            for (int i = 0; i < n; i++) {
                // Generate permutations with the current character added to the prefix
                generatePermutationsHelper(prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1),
                        uniquePermutations);
            }
        }
    }

    // Non-recursive method to generate permutations using Heap's algorithm
    // Non-recursive method to generate permutations using Heap's algorithm
    public static List<String> generateNonRecursivePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        int n = str.length();
        int[] c = new int[n];
        char[] chars = str.toCharArray();
        permutations.add(str); // Add the initial string

        for (int i = 0; i < n;) {
            if (c[i] < i) {
                // Swap the character at index i with the character at index c[i]
                int j = (i % 2 == 0) ? 0 : c[i]; // Choose the index for swapping
                char temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;

                // Create a new permutation from the modified array and add it to the list
                permutations.add(new String(chars));

                c[i]++;
                i = 0; // Restart for the next index
            } else {
                c[i] = 0; // Reset for the current index
                i++;
            }
        }
        return permutations;
    }

}
