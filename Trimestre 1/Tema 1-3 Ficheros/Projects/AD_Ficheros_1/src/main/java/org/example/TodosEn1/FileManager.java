package org.example.TodosEn1;

import org.apache.commons.io.FileUtils;
import org.example.Colors;

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
                case 3 -> createFile();
                case 4 -> deleteFile();
                case 5 -> showFileData();
                case 6 -> showFolderData();
                default -> {}
            }
        }

    }

    public void createFolder(String name) {
        File file = new File(name);

        if (!file.mkdir()) {
            if (file.exists() && file.isDirectory()) {
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
        }
    }

    public void createFile() throws IOException {
        String fileName = " ";
        while (fileName.replace(" ", "").isEmpty() || !fileName.contains(".") ) {
            System.out.print(color.cyan + "File Name: ");
            fileName = scanner.nextLine();
            if (!fileName.contains(".")) {System.out.println(color.red + "File " + basePath + fileName + " require extension");}
        }
        createFile(basePath + fileName);
    }

    public void deleteFolder() throws IOException {
        String folderName = " ";
        folderName = scanner.nextLine();

        while (folderName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "Folder Name: ");
            folderName = scanner.nextLine();
        }
        File file = new File(basePath + folderName);
        if (file.exists() && file.isDirectory()) {
            FileUtils.deleteDirectory(file);
            System.out.println(color.yellow + "Folder " + folderName + " deleted");
        }
        else {
            System.out.println(color.red + "Folder "+ basePath + folderName + " doesn't exist");
        }
    }

    public void deleteFile() throws IOException {
        String fileName = " ";
        fileName = scanner.nextLine();

        while (fileName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "File Name: ");
            fileName = scanner.nextLine();
        }
        File file = new File(basePath + fileName);
        if (file.delete()) {
            FileUtils.deleteDirectory(file);
            System.out.println(color.yellow + "File " + fileName + " deleted");
        }
        else {
            System.out.println(color.red + "File "+ basePath + fileName + " doesn't exist");
        }
    }

    public void showFileData() {
        String fileName = " ";
        while (fileName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "File Name: ");
            fileName = scanner.nextLine();
        }
        System.out.println(color.yellow + " - INFORMACIÓN SOBRE EL FICHERO - ");
        File f = new File(basePath + fileName);
        if(f.exists()){
            System.out.println(color.yellow + "Name            : "+ color.cyan + f.getName());
            System.out.println(color.yellow + "Path            : "+ color.cyan + f.getPath());
            System.out.println(color.yellow + "Absolute Path   : "+ color.cyan + f.getAbsolutePath());
            System.out.println(color.yellow + "Read            : "+ color.cyan + f.canRead());
            System.out.println(color.yellow + "Write           : "+ color.cyan + f.canWrite());
            System.out.println(color.yellow + "Size            : "+ color.cyan + f.length()+ " Kb");
            System.out.println(color.yellow + "Diretory        : "+ color.cyan + f.isDirectory());
            System.out.println(color.yellow + "File            : "+ color.cyan + f.isFile());
            System.out.println(color.yellow + "Father Name     : "+ color.cyan + f.getParent());
        }
    }

    public void showFolderData() {
        String folderName = " ";
        while (folderName.replace(" ", "").isEmpty()) {

            System.out.print(color.cyan + "File Name: ");
            folderName = scanner.nextLine();
        }
        System.out.println(color.yellow + " - INFORMACIÓN SOBRE EL DIRECTORIO - ");
        File folder = new File(basePath + folderName);
        if(folder.exists()){
            System.out.println(color.yellow + "Name                : "+ color.cyan + folder.getName());
            System.out.println(color.yellow + "Path                : "+ color.cyan + folder.getPath());
            System.out.println(color.yellow + "Absolute Path       : "+ color.cyan + folder.getAbsolutePath());
            System.out.println(color.yellow + "Read                : "+ color.cyan + folder.canRead());
            System.out.println(color.yellow + "Write               : "+ color.cyan + folder.canWrite());
            System.out.println(color.yellow + "Size                : "+ color.cyan + folder.length()+ " Kb"); // El tamaño es expresado en bytes
            System.out.println(color.yellow + "Directory           : "+ color.cyan + folder.isDirectory());
            System.out.println(color.yellow + "File                : "+ color.cyan + folder.isFile());
            System.out.println(color.yellow + "Father Name         : "+ color.cyan + folder.getParent());
        }
    }

    public void showFolders() {

    }
}
