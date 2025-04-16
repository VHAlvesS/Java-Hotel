import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("Transilvânia");
        boolean isRunning = true;

        while (isRunning) {
        showOptions();
        String options = scanner.nextLine();
        if(options.equals("1")) {
            System.out.println("What is the name of the client?");
            String clientName = scanner.nextLine();
            hotel.addClient(clientName);
        }
        else if(options.equals("2")) {
            System.out.println("What is the name of the client?");
            String clientName = scanner.nextLine();
            addBooking(hotel, clientName);
        }
        else if(options.equals("3")) {
            System.out.println("What is the name of the client that booked the room?");
            String clientName = scanner.nextLine();
            System.out.println(hotel.getReserves(clientName));
        }
        else if(options.equals("4")) {
            hotel.getAllReserves();
            System.out.println(hotel.getAllReserves());
        }
        else if(options.equals("5")) {
            isRunning = false;
        }
        else {
            System.out.println("Invalid option, try again!");
        }

        }


    }

    public static void showOptions() {
        System.out.println("Select a option \n 1. Add a new Person \n 2. Register a Booking \n 3. List a booking \n 4. List all Reserves \n 5. Exit");
    }

    public static String addBooking(Hotel hotel, String name) {
        Scanner bookingScanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        boolean isValidClient = false;

        for(String ClientName : hotel.getClientsName()) {
            if(name.equals(ClientName)) {
                isValidClient = true;
                break;
            }
        }

        while(!isValidClient) {
            System.out.println("The client does not exists, try again or cancel booking and create a client. \n 1. Try again \n 2. cancel");
            int option = bookingScanner.nextInt();
            bookingScanner.nextLine();

            if(option != 1 && option != 2) {
                System.out.println("Something went wrong, try a valid option.");
                continue;
            }
            if(option == 2) {
                return "cancelled";
            }
            if(option == 1) {
                System.out.print("Enter the client name: ");
                name = bookingScanner.nextLine();
                for(String ClientName : hotel.getClientsName()) {
                    if(name.equals(ClientName)) {
                        isValidClient = true;
                        break;
                    }
                }
            }
        }

        System.out.println("What is the room?");
        String room = bookingScanner.nextLine();


        System.out.println("What is the checkIn date? The formated needs to be in dd/MM/yyyy!");
        boolean isValidCheckIn = false;
        String checkInDateInput = bookingScanner.nextLine();
        Date checkInDate = null;

        while(!isValidCheckIn) {
            try{
                checkInDate = sdf.parse(checkInDateInput);
                isValidCheckIn = true;
            }
            catch(Exception e){
                System.out.println("Invalid date. Try again or cancel. \n 1. Try again \n 2. cancel");

                int option = bookingScanner.nextInt();
                bookingScanner.nextLine();

                if(option != 1 && option != 2) {
                    System.out.println("Something went wrong, try a valid option.");
                    continue;
                }
                if(option == 2) {
                    return "cancelled";
                }
                if(option == 1) {
                    System.out.print("Enter a valid date, it must be in dd/MM/yyyy: ");
                    checkInDateInput = bookingScanner.nextLine();
                }
            }
        }

        System.out.println("What is the checkOut date? The formated needs to be in dd/MM/yyyy!");
        boolean isValidCheckOut = false;
        String checkOutDateInput = bookingScanner.nextLine();
        Date checkOutDate = null;

        while(!isValidCheckOut) {
            try{
                checkOutDate = sdf.parse(checkOutDateInput);
                isValidCheckOut = true;
            }
            catch(Exception e){
                System.out.println("Invalid date. Try again or cancel. \n 1. Try again \n 2. cancel");

                int option = bookingScanner.nextInt();
                bookingScanner.nextLine();

                if(option != 1 && option != 2) {
                    System.out.println("Something went wrong, try a valid option.");
                    continue;
                }
                if(option == 2) {
                    return "cancelled";
                }
                if(option == 1) {
                    System.out.print("Enter a valid date, it must be in dd/MM/yyyy: ");
                    checkOutDateInput = bookingScanner.nextLine();
                }
            }
        }

        hotel.addBooking(room, checkInDate, checkOutDate, name);

        return "Booking created";
    }

}