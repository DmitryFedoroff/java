package main;

import validation.*;
import function.FilePathFinder;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileNameValidator fileNameValidator = new TotalFilesAndDirectoriesValidator(scanner);

        System.out.print("Enter file name: ");
        String query = fileNameValidator.validateFileName();

        TotalCountValidator totalCountValidator = new FilesAndDirectoriesCountValidator(scanner);

        System.out.print("Enter total number of files and directories: ");
        int n = totalCountValidator.validateTotalCount();

        System.out.println("Enter information about files and directories in specified format.");
        System.out.println("Directory or file inside another directory is separated by one extra space at beginning of line:");

        FilesAndDirectoriesValidator filesAndDirectoriesValidator = new TotalFilesAndDirectoriesValidator(scanner);
        String[] filesAndDirectories = filesAndDirectoriesValidator.validateFilesAndDirectories(n);

        FilePathFinder finder = new FilePathFinder();
        String result = finder.findPath(query, n, filesAndDirectories);

        System.out.println("Path to file: " + result);
        scanner.close();
    }
}