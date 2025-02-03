Table of Contents
Airline Management System...................................................................................................................................2
Features......................................................................................................................................................................2
Prerequisites ............................................................................................................................................................2
Database Setup.............................................................................................................................................................2
reservation Table ...................................................................................................................................................2
cancel Table..............................................................................................................................................................2
flight Table ................................................................................................................................................................3
Classes Overview.........................................................................................................................................................3
1. JourneyDetails.java ...........................................................................................................................................3
2. Cancel.java............................................................................................................................................................3
3. FlightInfo.java......................................................................................................................................................4
4. Conn.java...............................................................................................................................................................4
Running the Application...........................................................................................................................................4
Notes for Improvement............................................................................................................................................5













# Airline Management System

## Overview
The **Airline Management System** is a Java-based application designed to manage flight reservations, cancellations, journey details, and flight information. The system includes a **Graphical User Interface (GUI)** that interacts with a **MySQL database** to fetch and store relevant data.

## Features
- **Journey Details**: Retrieve and display journey details using the Passenger Name Record (**PNR**).
- **Ticket Cancellation**: Cancel flight tickets by entering the PNR and confirming the cancellation.
- **Flight Information**: View all available flights stored in the database.
- **Database Integration**: Utilizes **MySQL** to store, update, and delete reservation and cancellation data.

## Prerequisites
Before running the project, ensure you have the following installed:
- **Java**: Version 8 or higher.
- **MySQL**: For database management.
- **JDBC Driver**: For MySQL (included in the project).

## Database Setup
1. Open MySQL and create a database named **`airlinemanagementsystem`**.
2. Create the required tables by executing the following SQL statements:

```sql
CREATE TABLE reservation (
    PNR VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    flightcode VARCHAR(20),
    ddate DATE
);

CREATE TABLE cancel (
    PNR VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    cancellationno VARCHAR(20),
    flightcode VARCHAR(20),
    ddate DATE
);

CREATE TABLE flight (
    flightcode VARCHAR(20) PRIMARY KEY,
    flightname VARCHAR(100),
    source VARCHAR(100),
    destination VARCHAR(100),
    duration VARCHAR(50),
    price DECIMAL(10,2)
);
```

3. Insert sample data into the `reservation`, `flight`, and `cancel` tables to test the system.

## Class Overview

### `JourneyDetails.java`
This class allows users to view journey details by entering the **PNR**.
- **PNR Input Field**: Users input the PNR to fetch details.
- **Show Details Button**: Displays journey details in a table.

### `Cancel.java`
This class handles ticket cancellations.
- **PNR Input Field**: Users enter the PNR to fetch reservation details.
- **Show Details Button**: Displays reservation details.
- **Cancel Button**: Removes the reservation and adds cancellation details to the `cancel` table.

### `FlightInfo.java`
This class displays all available flights in a scrollable table.
- **Flight Table**: Lists flight code, source, destination, duration, and price.

### `Conn.java`
Handles the MySQL database connection.
- Establishes and maintains database connections.
- Executes SQL queries for data retrieval and manipulation.

## Running the Application

### Step 1: Setup the Database
- Open MySQL and create the database and tables as described above.
- Populate the tables with sample data.

### Step 2: Configure the Database Connection
- Open `Conn.java` and ensure the database connection string and credentials are correct:

```java
c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "12345");
```

### Step 3: Compile and Run the Java Classes
Compile the Java files using:

```bash
javac JourneyDetails.java Cancel.java FlightInfo.java
```

### Step 4: Use the Application
- **JourneyDetails**: Enter PNR to view journey details.
- **Cancel**: Enter PNR to cancel reservations.
- **FlightInfo**: View available flights.

## Notes for Improvement
- **SQL Injection Protection**: Use **PreparedStatement** to prevent SQL injection attacks.
- **Code Reusability**: Improve database connection handling using **connection pooling**.

---

This README provides a clear and structured guide for setting up and using the Airline Management System.
