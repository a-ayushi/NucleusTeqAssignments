// Implement a simple file I/O operation to read data from a text file.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SimpleInputOutout {
    public static void main(String[] args) {
        String filePath = "read.txt";

        try {
            // creating filereader and buffrered reader objects
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            System.out.println("Reading file:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File at " + filePath + "not found!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
