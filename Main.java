import java.util.Scanner;

public class Main {

    
    static final int ROWS = 5;
    static final int COLS = 5;
    static String[][] seats = new String[ROWS][COLS];

    public static void main(String[] args) {
        
        initializeSeats();

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
        
            System.out.println("\n------ Movie Ticket Booking System ------");
            System.out.println("1. Display Seats");
            System.out.println("2. Book a Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    displaySeats();
                    break;
                case 2:
                    bookTicket(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 3);
        
        scanner.close();
    }

    
    public static void initializeSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seats[i][j] = "Available";
            }
        }
    }

    
    public static void displaySeats() {
        System.out.println("\nCinema Seat Layout: ");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(seats[i][j] + "\t");
            }
            System.out.println();
        }
    }

   
    public static void bookTicket(Scanner scanner) {
        System.out.print("Enter the row number (1 to " + ROWS + "): ");
        int row = scanner.nextInt() - 1;  
        System.out.print("Enter the column number (1 to " + COLS + "): ");
        int col = scanner.nextInt() - 1; 

       
        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            if (seats[row][col].equals("Available")) {
                seats[row][col] = "Booked"; 
                System.out.println("Ticket successfully booked for seat (" + (row + 1) + ", " + (col + 1) + ")");
            } else {
                System.out.println("Sorry, this seat is already booked.");
            }
        } else {
            System.out.println("Invalid seat selection. Please try again.");
        }
    }
}
