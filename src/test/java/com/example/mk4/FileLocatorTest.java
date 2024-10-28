package com.example.mk4;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class FileLocatorTest {

    @Test
    void testFileExists() {
        File directory = new File("C:\\Users\\HP\\OneDrive\\Desktop\\testing");
        boolean result = FileLocator.searchFile(directory, "myson.txt");
        assertTrue(result, "The file should be found in the directory.");
    }

    @Test
    void testFileDoesNotExist() {
        File directory = new File("C:\\Users\\HP\\OneDrive\\Desktop\\testing");
        boolean result = FileLocator.searchFile(directory, "myson.json");
        assertFalse(result, "The file should not be found in the directory.");
    }

    @Test
    void testInvalidDirectory() {
        File directory = new File("C:\\Users\\HP\\OneDrive\\Desktop\\testing\\test");
        boolean result = FileLocator.searchFile(directory, "myson.txt");
        assertFalse(result, "The search should return false for an invalid directory.");
    }
}
