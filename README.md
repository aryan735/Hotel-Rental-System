# Hotel Rental System

A simple Java-based console application to manage hotel room rentals. The system allows customers to rent and return rooms, providing a streamlined process for managing room availability and customer details.

## Features
- **Rent a Room**: Customers can rent available rooms by providing their personal details, such as name, age, and contact information.
- **Return a Room**: After completing their stay, customers can return the room, making it available for future rentals.
- **Room Availability**: The system tracks room availability and calculates the rental price based on the number of days rented.

## Project Structure

- **Room**: Represents a room in the hotel, storing details like room ID, type, price, and availability status.
- **Customer**: Represents a customer with personal details such as name, age, gender, marital status, and phone number.
- **Rental**: Handles the association between a customer and a room for a specified number of days.
- **HotelRentalSystem**: The main system that manages rooms, customers, rentals, and overall operations such as renting and returning rooms.

## How It Works

1. **Room Rental**: 
   - The system displays available rooms.
   - Customers enter their details and select a room to rent.
   - The system calculates the total rental price and confirms the booking.
   
2. **Room Return**: 
   - Customers can return the room after their stay.
   - The system updates the availability of the room.

## Prerequisites

- **Java**: Ensure you have Java 8 or higher installed on your system.

## How to Run

1. Clone the repository or download the project files.
2. Open the project in your preferred IDE or compile it using the terminal.
3. Run the `Hotel.java` file to start the application.
4. Follow the on-screen instructions to rent or return rooms.

## Sample Usage

```
=======================
  HOTEL RENTAL SYSTEM  
=======================
1. Rent a Room
2. Return a Room
3. Exit
Enter your option: 1

Enter your name: John Doe
Enter your Id: 101
Enter your Age: 30
Enter your Gender: Male
Enter your Marital Status: Single
Enter your Phone No: 123-456-7890

Available Rooms:
101 - 1BHK
102 - 2BHK
103 - 3BHK
Enter The Room Id That You Want To Rent: 101
Enter The Number Of Days For Rental: 3

==============================
      RENTAL INFORMATION      
==============================
Customer ID :Cus1
Customer Name John Doe
Customer Age :30
Customer Gender :Male
Customer Marital Status :Single
Customer Phone Number :123-456-7890
Room :101 1BHK
Rental Days :3
Total Price $3000

Confirm Rental Y/N: Y

Room Rented Successfully!!!
