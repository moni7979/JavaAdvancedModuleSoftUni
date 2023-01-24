package StreamsFilesDirectories;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {

        String pathFolder = "C:\\Users\\Moni\\IdeaProjects\\AdvancedJava\\src\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        File folder = new File(pathFolder);

        File[] allFilesInFolder = folder.listFiles();

        int folderSize = 0;
        for (File file : allFilesInFolder) {
            folderSize += file.length();
        }
        System.out.println("Folder size: " + folderSize);
    }
}
