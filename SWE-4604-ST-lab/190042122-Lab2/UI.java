package Main;

public class UI {
    public String generateMessage;
    public void displayMainMenu() {
        System.out.println("Select operation:");
        System.out.println("1. Basic Operations");
        System.out.println("2. Advance Operations");
        System.out.println("3. Main.History");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }

    public void displayError(String message) {
        generateMessage = "Error: "+message;
        //System.out.println("Error: " + message);
        System.out.println(generateMessage);
    }
}
