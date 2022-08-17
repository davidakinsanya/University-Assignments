import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSummary {
    public static void main(String[] args) {
        File file = new File("numbers.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                System.out.print(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
