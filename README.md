# Car Selling Website

A web-based application for buying and selling cars, built using Java with Tomcat and backed by a PostgreSQL database.

## Features

- User registration and authentication
- Add, edit, and delete car listings
- Search and filter car listings by make, model, price, and other attributes
- Admin panel for managing users and listings
- Responsive design for mobile and desktop

## Technologies Used

- **Backend**: Java (Servlets, JSP), Apache Tomcat
- **Frontend**: HTML, CSS, JavaScript, Bootstrap
- **Database**: PostgreSQL
- **Tools**: Maven (for dependency management), Git

## Prerequisites

- Java JDK 11 or higher
- Apache Tomcat 9 or higher
- PostgreSQL 12 or higher
- Maven 3.6 or higher

## Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/car-selling-website.git](https://github.com/jbermejo14/BermeCarWeb.git
    cd BermeCarWeb
    ```

2. **Configure the PostgreSQL Database:**

   - Create a PostgreSQL database:
      Run the sql script in the DB server and add your DB credentials.
     
3. **startup Catalina.sh**

    ```bash
    apache-tomcat-9.0.87/bin/startup.sh
    ```

4. **Deploy to Apache Tomcat:**

   ```bash
   mvn tomcat9:deploy
    ```

5. **Run the application:**

   - Open your browser and navigate to `http://localhost:8082/bermecars`.

## Usage

User
  - **Home Page**: Browse car listings.
  - **User Registration/Login**: Create an account or log in to list your cars.
  - **Reservation Page**: Browse car reservation.
    
Admin
  - **Admin Panel**: Manage users, car listings and reservations (Admin access required).


