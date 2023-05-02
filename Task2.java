import java.util.Scanner;
import java.io.FileNotFoundException;

public class ComputerShopDriver {
    
    public static void main(String[] args) {
        
        ComputerShop shop = new ComputerShop();
        
        try {
            shop.loadPartsData();
        } catch (FileNotFoundException e) {
            System.out.println("Could not read from parts file.");
            System.exit(1);
        }
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Computer Shop Menu:");
            System.out.println("1. Show Parts");
            System.out.println("2. Report Parts");
            System.out.println("3. Sell a Part");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    shop.showParts();
                    break;
                case 2:
                    try {
                        shop.reportParts();
                        System.out.println("Parts report created successfully.");
                    } catch (FileNotFoundException e) {
                        System.out.println("Could not create parts report file.");
                    }
                    break;
                case 3:
                    System.out.println("Select a part to sell:");
                    int i = 1;
                    for (Part part : shop.getParts()) {
                        System.out.println(i + ". " + part.getName() + " - Quantity: " + part.getQuantity());
                        i++;
                    }
                    System.out.print("Enter the number of the part to sell: ");
                    int partNumber = scanner.nextInt();
                    scanner.nextLine();
                    if (partNumber > 0 && partNumber <= shop.getParts().size()) {
                        Part selectedPart = shop.getParts().get(partNumber - 1);
                        if (selectedPart.getQuantity() > 0) {
                            selectedPart.setQuantity(selectedPart.getQuantity() - 1);
                            System.out.println("Part sold successfully.");
                        } else {
                            System.out.println("Part is out of stock.");
                        }
                    } else {
                        System.out.println("Invalid part number.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
