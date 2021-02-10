package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class IO {

    private Path path;
    private Path file;

    public IO(String p, String f){
        this.path = Paths.get(p);
        this.file = Paths.get(p,f);

        if (Files.notExists(path)){
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.err.println("Could not create directory.");
                e.printStackTrace();
            }
        }

        if (Files.notExists(this.file)) {
            try {
                Files.createFile(this.file);
            } catch (IOException e) {
                System.err.println("Could not create file.");
                e.printStackTrace();
            }
        }

    }

    public List<String> getList(){
        List<String> arr;
        try {
            arr = Files.readAllLines(this.file);
            return arr;
        } catch (IOException e) {
            System.err.println("Could not read file.");
            e.printStackTrace();
        }
        return null;
    }

    public void writeLines(List<String> lines){
        try {
            Files.write(
                this.file, // This is the file path
                lines); // This is the contents being written
        } catch (IOException e) {
            System.err.println("Unable to write file.");
            e.printStackTrace();
        }
    }

    public void appendLine(List<String> lines){
        try {
            Files.write(
                    this.file, //filepath
                    lines, //contents
                    StandardOpenOption.APPEND); //options
        } catch (IOException e) {
            System.err.println("Unable to write file.");
            e.printStackTrace();
        }
    }



    

}
