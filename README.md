# Car Rental Reservation System

A Java-based **University-level project** developed for the **Data Structures and Algorithms (DSA)** and **Database Management** courses. This **Car Rental Reservation System** incorporates essential DSA concepts like linked lists, filters, queues, and stacks, alongside MySQL for database management. The project includes an **Admin Panel** for managing vehicles, customers, and rentals, as well as a **Customer Portal** for logging in and renting cars.

## Features

### Admin Panel
- **Vehicle Management**: Add, view, update, and delete vehicles available for rent.
- **Customer Management**: Add, view, and update customer information.
- **Rental Management**: Track and manage cars rented by customers.

### Customer Portal
- **Customer Registration & Login**: Customers can register and log in to access the rental system.
- **Rent a Car**: Logged-in customers can rent cars based on availability.

## Data Structures Used
This project uses several core data structures to manage system functionality:
- **Linked Lists**: Used to maintain customer and vehicle records efficiently.
- **Queues**: Manages waiting lists for vehicle rentals during peak demand.
- **Stacks**: Tracks recent actions for undo functionality within the admin panel.
- **Filters**: Implements search filters to allow users to find vehicles by criteria such as model, availability, etc.

## Technology Stack
- **Language**: Java
- **Database**: MySQL (using MySQL Workbench for database management)
- **Database Connection**: JDBC

## Database Structure

The MySQL database, named `vehicles`, contains the following tables:

1. **Table: vehicle**
   - `id` (INT, Primary Key): Unique identifier for each vehicle.
   - `category` (VARCHAR): Category/type of vehicle (e.g., sedan, SUV).
   - `model` (VARCHAR): Model year of the vehicle.
   - `vehicleName` (VARCHAR): Name or make of the vehicle.
   - `seatingCapacity` (INT): Number of seats available in the vehicle.
   - `rentPerHour` (DECIMAL): Rental price per hour.
   - `isAvailable` (BOOLEAN): Availability status of the vehicle.

2. **Table: customer**
   - `id` (INT, Primary Key): Unique identifier for each customer.
   - `name` (VARCHAR): Customer's full name.
   - `email` (VARCHAR): Customer's email address.

## Database Setup
1. Ensure MySQL is installed and running.
2. Use MySQL Workbench or a similar tool to create the database and tables as shown in the **Database Structure** section.
3. Update the JDBC connection details in the code with your MySQL username, password, and database name.

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/PirateCoderz/DSA-Final-Project.git
   ```
2. **Open in Your IDE** (e.g., Eclipse or IntelliJ).
3. **Configure Database Connection**:
   - Ensure `mysql-connector-java` is included in your project's libraries for JDBC connectivity.
   - Update database connection details in the `DatabaseConfig` class or relevant configuration file.

4. **Run the Application**:
   - Compile and run the main application file in your IDE.

## Usage

- **Admin Access**: Use the admin panel to manage vehicles, customers, and rental records.
- **Customer Access**: Customers can log in, view available cars, and make rental reservations.

## Future Enhancements
- **Payment Integration**: Add support for online payments.
- **Improved UI**: Implement a user-friendly graphical interface.

## Contributing
Contributions are welcome! Fork the repository, create a branch, and submit a pull request for review.

## License
This project is licensed under the MIT License.
