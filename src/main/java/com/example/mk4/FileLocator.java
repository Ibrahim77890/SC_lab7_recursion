package com.example.mk4;
import java.io.File;

public class FileLocator {

    /**
     * Entry point of the program.
     * Takes two command-line arguments: directory path and file name to search.
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java FileLocator <directory-path> <file-name>");
            return;
        }

        String directoryPath = args[0];
        String fileName = args[1];

        File directory = new File(directoryPath);
        
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Error: The specified directory does not exist or is not a directory.");
            return;
        }

        boolean found = searchFile(directory, fileName);
        if (!found) {
            System.out.println("File not found: " + fileName);
        }
    }

    /**
     * Recursively searches for a file within the given directory and its subdirectories.
     * @param directory The directory to search within.
     * @param fileName The name of the file to search for.
     * @return True if the file is found, false otherwise.
     */
    public static boolean searchFile(File directory, String fileName) {
        File[] files = directory.listFiles();  // Get list of files and directories

        if (files == null) return false;  // In case of permission issues

        for (File file : files) {
            if (file.isDirectory()) {
                // Recursive call to search within subdirectory
                if (searchFile(file, fileName)) {
                    return true;
                }
            } else if (file.getName().equals(fileName)) {
                System.out.println("File found: " + file.getAbsolutePath());
                return true;
            }
        }
        return false;
    }
}
