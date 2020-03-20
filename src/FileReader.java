import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> readFile(String fileName) {
        List<String> fileData = new ArrayList<String>();
        try {
            File fileDescriptor = new File(fileName);
            Scanner fileReader = new Scanner(fileDescriptor);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
                fileData.add(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return fileData;
    }
}
