# Basic Banking System

A simple banking application built with Spring Boot. This project demonstrates basic banking functionalities using Java, Spring Boot, Spring Security, MySQL, and a variety of frontend technologies including HTML, CSS, JavaScript, jQuery, and Thymeleaf.

## Technologies Used

- **Backend**: Java, Spring Boot, Spring Security
- **Database**: MySQL
- **Frontend**: HTML, CSS, JavaScript, jQuery, Thymeleaf

## Prerequisites

1. **MySQL Installation**: Ensure that MySQL is installed on your machine.
2. **Java 17 or Above**: Ensure that you have Java 17 or later installed and configured properly on your system.

## Installation and Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/username/basic-banking-system.git
   cd basic-banking-system
   
2. **Set Up the Database**
- Run the SQL scripts provided in the src/main/resources/database/scripts.sql file to create the necessary database and tables.

   ```bash
  mysql -u your-username -p < src/main/resources/database/scripts.sql

3. **Java Environment** 
   - Ensure Java 17 or above is installed and the path variables are set correctly.
   - Run the JAR file using the following command:

   ```bash
   java -jar bank-3.3.2.jar

2. **Access the Application**
- Once the application is running, you can access it locally at:

   ```arduino
   http://127.0.0.1:9000/bank/dashboard

4. **Usage**
- After starting the application, navigate to the URL provided above to view the application's home page. You can interact with the banking system, manage accounts, perform transactions, and more.

4. **Features**
- Perform deposits and withdrawals.