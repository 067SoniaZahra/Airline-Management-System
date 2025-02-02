AIRLINE MANAGEMENT SYSTEM

This is a Java-based Airline Management System that provides functionalities to manage flight reservations, cancellations, journey details, and flight information. The system includes a graphical user interface (GUI) that interacts with a MySQL database to fetch and store information.

FEATURES
- *Journey Details*: Fetches and displays the details of a specific journey using the Passenger Name Record (PNR).
- *Ticket Cancellation*: Allows users to cancel their flight tickets by entering the PNR and confirming the cancellation.
- *Flight Information*: Displays a list of all available flights in the database.
- *Database Integration*: Uses MySQL to store, update, and delete reservation and cancellation data.

PREREQUISITES
Before running the project, make sure to have the following installed:

- *Java*: Version 8 or higher.
- *MySQL*: For the database setup.
- *JDBC Driver*: For MySQL (included in the project).



DATABASE SETUP

1. Create a database named airlinemanagementsystem in MySQL.
2. Create the following tables:

RESERVATION TABLE
sql
CREATE TABLE reservation (
    PNR VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    flightcode VARCHAR(20),
    ddate DATE
);

CREATE TABLE cancel (
    PNR VARCHAR(20),
    name VARCHAR(100),
    cancellationno VARCHAR(20),
    flightcode VARCHAR(20),
    ddate DATE,
    PRIMARY KEY(PNR)
);

CREATE TABLE flight (
    flightcode VARCHAR(20) PRIMARY KEY,
    flightname VARCHAR(100),
    source VARCHAR(100),
    destination VARCHAR(100),
    duration VARCHAR(50),
    price DECIMAL(10, 2)
);

CLASSES OVERVIEW
1. JourneyDetails.java
This class allows users to view the journey details by entering the PNR. It fetches the data from the reservation table and displays it in a table format.

KEY COMPONENTS:

PNR Input Field: Users can input the PNR to fetch the journey details.
Show Details Button: Fetches and displays the journey details in a table.
2. Cancel.java
This class provides the ability to cancel a ticket by entering the PNR. It fetches the reservation details and displays them. Once confirmed, the ticket is canceled and removed from the reservation table, and a cancellation record is inserted into the cancel table.

KEY COMPONENTS:

PNR Input Field: Users can input the PNR to fetch reservation details.
Show Details Button: Fetches and displays reservation details.
Cancel Button: Removes the reservation and adds cancellation details.
3. FlightInfo.java
This class displays all the available flights stored in the flight table in a scrollable table format.

Key components:

Flight Table: Displays all flight information such as flight code, source, destination, duration, and price.
4. Conn.java
This class handles the connection to the MySQL database. It provides methods for executing SQL queries to retrieve and manipulate data.

RUNNING THE APPLICATION
Step 1: Setup Database
Open MySQL and create the required database and tables as mentioned above.
Insert some sample data into the reservation, flight, and cancel tables.
Step 2: Configure Database Connection
In the Conn.java file, make sure that the database connection string and credentials are correct:
 c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "12345");

Step 3: Compile and Run the Java Classes
Compile the Java files:
bash
Copy
Edit

ava JourneyDetails
java Cancel
java FlightInfo

Step 4: Use the Application
JourneyDetails: Input the PNR to view the journey details.
Cancel: Input the PNR to view the reservation and cancel it.
FlightInfo: View the list of available flights.
NOTES FOR IMPROVEMENT
SQL Injection Protection: Consider using PreparedStatement for database queries to prevent SQL injection attacks.
Code Reusability: The Conn class could be enhanced by implementing connection pooling to improve database connection handling.

    

