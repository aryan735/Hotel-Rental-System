import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room{
    private String roomId;
    private String roomType;
    private double basePricePerDay;
    private boolean isAvailable;

    public Room(String roomId,String roomType,double basePricePerDay){
        this.roomId=roomId;
        this.roomType= roomType;
        this.basePricePerDay= basePricePerDay;
        this.isAvailable= true;
    }
    public String getroomId(){
        return roomId;
    }

    public String getroomType(){
        return roomType;
    }
    public double calculatePrice(int rentalDays){
        return basePricePerDay*rentalDays;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
       public void rentRoom(){
        isAvailable=false;//if the room is on rent then the room's availability is false
    }
    public  void returnRoom(){
        isAvailable=true;
    }
}

class Customer {
    private String customerName;
    private String customerId;
    private int customerAge;
    private String customerGender;
    private String customerMaritalStatus;
    private String customerPhoneNo;

    public Customer(String customerId,String customerName, int customerAge, String customerGender, String customerMaritalStatus, String customerPhoneNo) {
        this.customerName = customerName;
        this.customerId=customerId;
        this.customerAge=customerAge;
        this.customerGender=customerGender;
        this.customerMaritalStatus=customerMaritalStatus;
        this.customerPhoneNo=customerPhoneNo;

    }
    public String getCustomerName(){
        return customerName;
    }
    public String getCustomerId(){
        return customerId;
    }
    public int getCustomerAge(int customerAge){
        if (customerAge>18){
            return customerAge;
        }else {
            System.out.println("You are not Eligible!!!");
            System.exit(0);
        }
       return 0;
    }
    public String getCustomerGender(){
        return customerGender;
    }
    public String getCustomerMaritalStatus(){
        return customerMaritalStatus;
    }
    public String getCustomerPhoneNo(){
        return customerPhoneNo;
    }

}

class Rental{
    private Room room;
    private Customer customer;
    private int days;

    public Rental(Room room,Customer customer,int days){
        this.room=room;
        this.customer=customer;
        this.days=days;
    }
    public Room getRoom(){
        return room;
    }
    public Customer getCustomer(){
        return customer;
    }
    public int getDays(){
        return days;
    }
}
class HotelRentalSystem{
    private List<Room>rooms;//Declaration
    private List<Customer>customers;
    private List<Rental>rentals;

    public HotelRentalSystem(){//Created in the memory
        rooms = new ArrayList<>();
        customers= new ArrayList<>();
        rentals = new ArrayList<>();
    }
    public void addRooms(Room room){
        rooms.add(room);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void addRent(Room room,Customer customer,int days){
        if(room.isAvailable()){
            room.rentRoom();
            rentals.add(new Rental(room,customer,days));
        }else{
            System.out.println("The room is not available for rent!!!");
        }
    }


    public void returnRoom(Room room){
        room.returnRoom();
        Rental rentaltoremove = null;
        for(Rental rental:rentals){
            if(rental.getRoom()==room){//Rental class obj rental calling the getroom method
                rentaltoremove=rental;
                break;
            }
            if(rentaltoremove!=null){
                rentals.remove(rentaltoremove);
            }else {
                System.out.println("Room was not returned");
            }
        }
    }
    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=======================");
            System.out.println("  HOTEL RENTAL SYSTEM  ");
            System.out.println("=======================");
            System.out.println("1. Rent a Room");
            System.out.println("2. Return a Room");
            System.out.println("3. Exit");
            System.out.print("Enter your option:");
            int option = sc.nextInt();
            sc.nextLine(); // Consume the newline after nextInt()

            if (option == 1) {
                System.out.println("=======================");
                System.out.println("      RENT A ROOM      ");
                System.out.println("=======================");
                System.out.print("Enter your name: ");
                String customerName = sc.nextLine(); // Correctly consume the input
                System.out.print("Enter your Id: ");
                int customerId = sc.nextInt();
                sc.nextLine(); // Consume the newline after nextInt()
                System.out.print("Enter your Age: ");
                int customerAge = sc.nextInt();
                sc.nextLine(); // Consume the newline after nextInt()
                System.out.print("Enter your Gender: ");
                String customerGender = sc.nextLine();
                System.out.print("Enter your Marital Status: ");
                String customerMaritalStatus = sc.nextLine();
                System.out.print("Enter your Phone No: ");
                String customerPhoneNo = sc.nextLine();

                System.out.println("\nAvailable Rooms:\n");
                for (Room room : rooms) {
                    if (room.isAvailable()) {
                        System.out.println(room.getroomId() + " - " + room.getroomType());
                    }
                }
                System.out.print("Enter The Room Id That You Want To Rent: ");
                String roomId = sc.nextLine();
                System.out.print("Enter The Number Of Days For Rental: ");
                int rentalDays = sc.nextInt();
                sc.nextLine(); // Consume the newline

                Customer newCustomer = new Customer("Cus" + (customers.size() + 1),customerName,customerAge, customerGender,customerMaritalStatus,customerPhoneNo);
                addCustomer(newCustomer);

                Room selectedRoom = null;
                for (Room room : rooms){
                    if (room.getroomId().equals(roomId) && room.isAvailable()) {
                        selectedRoom=room;
                        break;
                    }
                }
                if (selectedRoom!=null){
                    double totalPrice = selectedRoom.calculatePrice(rentalDays);
                    System.out.println("==============================");
                    System.out.println("      RENTAL INFORMATION      ");
                    System.out.println("==============================");
                    System.out.println("Customer ID :"+newCustomer.getCustomerId());
                    System.out.println("Customer Name "+newCustomer.getCustomerName());
                    System.out.println("Customer Age :"+newCustomer.getCustomerAge(customerAge));
                    System.out.println("Customer Gender :"+newCustomer.getCustomerGender());
                    System.out.println("Customer Marital Status :"+newCustomer.getCustomerMaritalStatus());
                    System.out.println("Customer Phone Number :"+newCustomer.getCustomerPhoneNo());
                    System.out.println("Room :"+selectedRoom.getroomId()+" "+selectedRoom.getroomType());
                    System.out.println("Rental Days :"+rentalDays);
                    System.out.println("Total Price $"+totalPrice);

                    System.out.println("\nConfirm Rental Y/N");
                    String confirm = sc.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        addRent(selectedRoom,newCustomer,rentalDays);
                        System.out.println("\nRoom Rented Successfully!!!");
                    }else{
                        System.out.println("\nRental Canceled");
                    }
                }else {
                    System.out.println("Invalid Room selection or Room not available for Rent");
                }
            }
            else if (option==2) {
                System.out.println("========================");
                System.out.println("     RETURN A ROOM      ");
                System.out.println("========================");
                System.out.print("Enter the Room ID that you want to return: ");
                String roomId = sc.nextLine();

                Room roomToReturn = null;
                for (Room room:rooms){//Room checked in the room list
                    if (room.getroomId().equals(roomId) && !room.isAvailable()){
                        roomToReturn=room;
                        break;
                    }
                }
                if (roomToReturn!=null){//Room checked in the rental list
                    Customer customer =null;
                    for (Rental rental:rentals){
                        if (rental.getRoom()==roomToReturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if (customer!=null){
                        returnRoom(roomToReturn);
                        System.out.println("Room Returned Successfully by "+customer.getCustomerName());
                    }else {
                        System.out.println("Room was not Rented or Rental Information is missing!!!");
                    }
                }else {
                    System.out.println("Invalid Room Id or Room is not Rented!!!");
                }

            }
            else if (option==3) {
                System.out.println("ThankYou for using the Hotel Rental System!!!");

                return;
            }
            else {
                System.out.println("Invalid Option...Please Enter A Valid Option!!!");
            }

        }
    }

}


public class Hotel {
    public static void main(String[] args) {
        HotelRentalSystem rentalSystem=new HotelRentalSystem();
        Room room1 = new Room("101","1BHK",1000);
        Room room2 = new Room("102","2BHK",2000);
        Room room3 = new Room("103","3BHK",3000);
        rentalSystem.addRooms(room1);
        rentalSystem.addRooms(room2);
        rentalSystem.addRooms(room3);

        rentalSystem.menu();
    }

}
