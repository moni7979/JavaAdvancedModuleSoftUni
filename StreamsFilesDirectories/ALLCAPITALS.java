package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Moni\\IdeaProjects\\AdvancedJava\\src\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        List<String> allLines = Files.readAllLines(Path.of(path));
        for (String line : allLines) {
            writer.write(line.toUpperCase(Locale.ROOT));
            writer.newLine();
        }
        writer.close();
    }
}
