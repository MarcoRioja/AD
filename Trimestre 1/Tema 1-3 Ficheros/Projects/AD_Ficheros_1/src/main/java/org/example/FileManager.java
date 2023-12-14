package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    Colors color = new Colors();
    int opMenu_1 = -1;
    String basePath = "testing/";

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        try {
            fileManager.createMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FileManager() {
        File file = new File(basePath);

        if (!file.mkdir()) {
            if (!file.exists()) {
                System.err.println("Folder creation failed - " + file.getName());
            }
        }
    }
    public void createMenu() throws IOException {
        while (opMenu_1 != 0) {
            System.out.println(color.green + " -------------------- o --------------------");
            System.out.println(color.green + " 1 - Create folder/directory");
            System.out.println(color.green + " 2 - Delete folder/directory");
            System.out.println(color.green + " 3 - Create file");
            System.out.println(color.green + " 4 - Delete file");
            System.out.println(color.green + " 5 - Read file");
            System.out.println(color.green + " 6 - Show folders");
            System.out.println(color.green + " 0 - Exit");
            System.out.println(color.green + " -------------------- o --------------------");
            System.out.print(color.cyan + "Option: ");
            opMenu_1 = scanner.nextInt();
            switch (opMenu_1) {
                case 1 -> createFolder();
                case 2 -> deleteFolder();
                default -> {}
            }
        }

    }

    public void createFolder(String name) {
        File file = new File(name);

        if (!file.mkdir()) {
            if (file.exists()) {
                System.err.println("Folder creation failed - " + file.getName() + " - Already Exists");
            } else {
                System.err.println("Folder creation failed - " + file.getName());
            }
        } else {
            System.out.println(color.yellow + "Folder " + name + " created");
        }
    }

    public void createFolder() {
        String folderName = " ";

        while (folderName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "Folder Name: ");
            folderName = scanner.nextLine();
        }
        createFolder(basePath + folderName);
    }

    public void deleteFolder() throws IOException {
        String folderName = " ";
        folderName = scanner.nextLine();

        while (folderName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "Folder Name: ");
            folderName = scanner.nextLine();
        }
        File file = new File(basePath + folderName);
        FileUtils.deleteDirectory(file);
        System.out.println(color.yellow + "Folder " + folderName + " deleted");
    }

    public void showFolders() {

    }
}
