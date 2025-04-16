import java.util.ArrayList;
import java.util.Date;

public class Hotel {
    public String name;
    private ArrayList<Person> clients;

    public Hotel(String name) {
        this.name = name;
        this.clients = new ArrayList<>();
    }

    public String getReserves(String clientName){
        for (Person client : clients) {
            if(client.name.equals(clientName)) {
                String result = "Reserves: ";
                if (client.getReserves() == null) {
                    return "Reserves not found";
                }
                for (Reserve reserve : client.getReserves()) {
                    result += reserve.toString() + " ";
                }

                return (result);
            }
        }
        return "Nothing found";
    }
    public String getAllReserves(){
        ArrayList<Reserve> allReserves = new ArrayList<>();
        String result = "Listing all reserves: ";

            for(Person client : clients) {
                for(Reserve r:client.getReserves()) {
                    result += r.toString() + " ";
                }
            }

            return (result);
    }
    public String[] getClientsName() {
        String[] clientsName = new String[this.clients.size()];

        for(int i = 0; i < this.clients.size(); i++) {
            clientsName[i] = this.clients.get(i).name;
        }

        return clientsName;
    }

    public void addClient(String name){
        Person newClient = new Person(name);
        this.clients.add(newClient);
    }

    public void addBooking(String room, Date checkIn, Date checkout, String clientName){
        for(Person client : clients) {
            if(clientName.equals(client.name)) {
                client.addABooking(room, checkIn, checkout);
                return;
            }
        }
    }

    public String getName(){
        return this.name;
    }
}
