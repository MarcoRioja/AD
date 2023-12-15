package org.example.Menu;

import org.apache.commons.io.FileUtils;
import org.example.Utils.Colors;

import java.io.*;
import java.util.Scanner;

public class FileManager {

    Colors color = new Colors();
    int opMenu_1 = -1;
    String basePath = "testing/";
    Scanner scanner = new Scanner(System.in);
    public String author = "MK";

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
            System.out.println(color.green + " 1 -  Create folder/file");
            System.out.println(color.green + " 2 -  Delete folder/file");
            System.out.println(color.green + " 3 -  Read File");
            System.out.println(color.green + " 4 -  Write File");
            System.out.println(color.green + " 5 -  Folder/File data");
            System.out.println(color.green + " 6 -  Show Folder Files");
            System.out.println(color.green + " 7 -  Enter to Folder");
            System.out.println(color.green + " 8 -  Back to Main Folder");
            System.out.println(color.green + " 0 -  Exit");
            System.out.println(color.yellow + " - You are in " + basePath + " -");
            System.out.println(color.green + " -------------------- o --------------------");
            System.out.print(color.cyan + "Option: ");
            opMenu_1 = scanner.nextInt();
            switch (opMenu_1) {
                case 1 -> createOption();
                case 2 -> deleteOption();
                case 3 -> readFile();
                case 4 -> writeFile();
                case 5 -> showFileData();
                case 6 -> showFolders();
                case 7 -> moveTo();
                case 8 -> back();
                default -> {System.out.println(color.blue + "- BYEEE!! :D -");}
            }
        }

    }

    public void createOption() throws IOException {
        String fileName = " ";

        while (fileName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "Introduce a folder/file name (Use . for file extensions): ");
            fileName = scanner.nextLine();
        }

        if (fileName.contains(".") && !(fileName.charAt(0) == '.')) {
            createFile(basePath + fileName);
        } else {
            createFolder(basePath + fileName);
        }
    }

    public void createFolder(String name) {
        File file = new File(name);

        if (!file.mkdir()) {
            if (file.exists() && file.isDirectory()) {
                System.out.println(color.red + "Folder creation failed - " + file.getName() + " - Already Exists");
            } else {
                System.out.println(color.red + "Folder creation failed - " + file.getName());
            }
        } else {
            System.out.println(color.yellow + "Folder " + name + " created");
        }
    }

    public void createFile(String name) throws IOException {
        File file = new File(name);

        if (!file.createNewFile()) {
            if (file.exists()) {
                System.err.println("File creation failed - " + file.getName() + " - Already Exists");
            } else {
                System.err.println("File creation failed - " + file.getName());
            }
        } else {
            System.out.println(color.yellow + "File " + name + " created");
            String write = "";
            do {
                System.out.println(color.cyan + "Do yo want to write in the file? (yes/no)");
                write = scanner.nextLine();
            } while (!write.equals("yes") && !write.equals("no"));
            if (write.equals("yes")) {writeFile(name);}
            do {
                System.out.println(color.cyan + "Show File text? (yes/no)");
                write = scanner.nextLine();
            } while (!write.equals("yes") && !write.equals("no"));
            if (write.equals("yes")) {readFile(name);}
        }
    }

    public void deleteOption() throws IOException {
        String fileName = " ";

        while (fileName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "Folder/File Name (Use . for files extensions): ");
            fileName = scanner.nextLine();
        }
        File file = new File(basePath + fileName);
        if (fileName.contains(".") && !(fileName.charAt(0) == '.')) {
            if (file.delete()) {
                System.out.println(color.yellow + "File " + fileName + " deleted");
            }
            else {
                System.out.println(color.red + "File "+ basePath + fileName + " doesn't exist");
            }
        }
        else {
            if (file.exists()) {
                FileUtils.deleteDirectory(file);
                file.delete();
                System.out.println(color.yellow + "Folder " + fileName + " deleted");
            }
            else {
                System.out.println(color.red + "Folder "+ basePath + fileName + " doesn't exist");
            }
        }

    }

    public void showFileData() {
        String fileName = " ";
        while (fileName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "Folder/File Name (Can use this): ");
            fileName = scanner.nextLine();
            if (fileName.equals("this")) {
                fileName = "";
                break;
            }
        }
        File f = new File(basePath + fileName);
        if(f.exists()){
            System.out.println(color.yellow + " - FILE DATA - ");
            System.out.println(color.yellow + "Name            : "+ color.magenta + f.getName());
            System.out.println(color.yellow + "Path            : "+ color.magenta + f.getPath());
            System.out.println(color.yellow + "Absolute Path   : "+ color.magenta + f.getAbsolutePath());
            System.out.println(color.yellow + "Read            : "+ color.magenta + f.canRead());
            System.out.println(color.yellow + "Write           : "+ color.magenta + f.canWrite());
            System.out.println(color.yellow + "Size            : "+ color.magenta + f.length()+ " Kb");
            System.out.println(color.yellow + "Diretory        : "+ color.magenta + f.isDirectory());
            System.out.println(color.yellow + "File            : "+ color.magenta + f.isFile());
            System.out.println(color.yellow + "Father Name     : "+ color.magenta + f.getParent());
            if (fileName.contains(".") && !(fileName.charAt(0) == '.')) {
                System.out.println(color.yellow + "File content    :");
                readFile(basePath+fileName);
            }
            else {
                System.out.println(color.yellow + "Folder Files    :");
                showFolders(basePath+fileName);
            }
        } else {
            System.out.println(color.red + "Folder/File "+ basePath + fileName + " doesn't exist");
        }
    }

    public void showFolders() {
        String folderName = " ";

        while (folderName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "Folder Name (Can use this): ");
            folderName = scanner.nextLine();
            if (folderName.equals("this")) {
                folderName = "";
                break;
            }
        }
        String finalPath = basePath + folderName;
        File folder = new File(finalPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(color.magenta + " - " +file.getName());
                }
                if (files.length == 0) {
                    System.out.println(color.red + "- Empty -");
                }
            }
        } else {
            System.out.println(color.red + "Folder/File "+ basePath + folderName + " doesn't exist");
        }
    }

    public void showFolders(String path) {
        File folder = new File(path);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(color.magenta + " - " +file.getName());
                }
                if (files.length == 0) {
                    System.out.println(color.red + "- Empty -");
                }
            }
        } else {
            System.out.println(color.red + "Folder "+ path + " doesn't exist");
        }
    }

    void moveTo() {
        String folderName = " ";

        while (folderName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "Enter to: ");
            folderName = scanner.nextLine();
        }
        File folder = new File(basePath + folderName);
        if (folder.exists()) {
            basePath = basePath + folderName + "/";
        } else{
            System.out.println(color.red + "Folder " + basePath + folderName + " doesn't exist");
        }
    }

    void back() {
        basePath = "testing/";
    }

    void readFile() {
        String fileName = " ";

        while (fileName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "File Name: ");
            fileName = scanner.nextLine();
        }
        File file = new File(basePath + fileName);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(basePath + fileName))) {
                String line;

                while ((line = br.readLine()) != null) {
                    System.out.println(color.magenta + line);
                }
            } catch (IOException e) {
                System.err.println(color.red + "Error: " + e.getMessage());
            }
        }
        else {
            System.err.println(color.red + "File doesn't exist");
        }
    }

    void readFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;

                while ((line = br.readLine()) != null) {
                    System.out.println(color.magenta + line);
                }
            } catch (IOException e) {
                System.err.println(color.red + "Error: " + e.getMessage());
            }
        }
        else {
            System.err.println(color.red + "File doesn't exist");
        }
    }

    void writeFile() {
        String fileName = " ";

        while (fileName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "File Name: ");
            fileName = scanner.nextLine();
        }
        File file = new File(basePath + fileName);
        if (file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(basePath + fileName))) {
                System.out.print(color.cyan + "Text To Write: ");
                String textToWrite = scanner.nextLine();
                bw.write(textToWrite);
                bw.newLine();
                System.out.println(color.yellow + "Write Correctly.");
            } catch (IOException e) {
                System.err.println(color.red + "Error: " + e.getMessage());
            }
        }
        else {
            System.err.println(color.red + "File doesn't exist");
        }
    }

    void writeFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                System.out.print(color.cyan + "Text To Write: ");
                String textToWrite = scanner.nextLine();
                bw.write(textToWrite);
                bw.newLine();
                System.out.println(color.yellow + "Write Correctly.");
            } catch (IOException e) {
                System.err.println(color.red + "Error: " + e.getMessage());
            }
        }
        else {
            System.err.println(color.red + "File doesn't exist");
        }
    }
}
