import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ComputerShop {
    
    private ArrayList<Part> parts;
    
    public ComputerShop() {
        parts = new ArrayList<Part>();
    }
    
    public void loadPartsData() throws FileNotFoundException {
        parts.clear();
        Scanner scanner = new Scanner(new File("parts.txt"));
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(",");
            String name = data[0];
            double price = Double.parseDouble(data[1]);
            Part part = new Part(name, price, 5);
            parts.add(part);
        }
        scanner.close();
    }
    
    public void showParts() {
        for (Part part : parts) {
            System.out.println(part.toString());
        }
    }
    
    public void reportParts() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("parts-report.txt");
        for (Part part : parts) {
            writer.println(part.toString());
        }
        writer.close();
    }
    
    public void addPart(Part part) {
        parts.add(part);
    }
}
