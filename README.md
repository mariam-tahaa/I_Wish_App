# Client–Server Wishlist Application

A **JavaFX client–server application** built using **Java, JavaFX, SQL, and PL/SQL**, following a **layered architecture** with **socket-based communication**.  

The system allows multiple users to manage wishlists, contribute to gifts, and interact socially through friend requests and notifications.

---

## Technologies Used

- Java
- JavaFX
- Socket Programming
- SQL / PL-SQL
- Oracle Database
- MVC + Layered Architecture

---

## Project Architecture

The project follows a **Client–Server architecture**, where the **client communicates with the server using sockets**.

---

## Project Structure

### Client Side

```text
client/
│
├── controllers/
│   └── Handle user inputs and UI actions
│
├── services/
│   └── Validate business logic before sending requests
│
├── network/
│   └── SocketClient (opens socket connection with server)
│
├── dto/
│   └── Defines data to be displayed for each user
│
├── dao/
│   └── Handles database queries (select, insert, update)
│
├── helpers/
│   ├── SessionManager
│   │   └── Stores current user ID and username
│
└── ui/
    └── JavaFX views (FXML files)
```

### Server Side

```text
server/
│
├── controllers/
│   └── Start and stop the server
│
├── services/
│   └── Business logic validation
│
├── network/
│   ├── RequestProcessor
│   │   └── Determines request type
│   └── ClientHandler
│       └── Handles multiple connected clients concurrently
│
├── ServerManager/
│   └── Starts and stops the server
│
├── dto/
│   └── Prepares response data for clients
│
├── dao/
│   └── Database access layer
│
├── helpers/
│   └── DBConnection
│       └── Manages database connection
│
└── database/
    └── SQL & PL-SQL scripts
```

### Project Cycle (Request Flow)

```text
Client enters data
      ↓
Client Controller
      ↓
Client Service
      ↓
SocketClient sends request
      ↓
Server receives request
      ↓
RequestProcessor identifies request type
      ↓
Server Controller
      ↓
Server Service
      ↓
DAO accesses database via DBConnection
      ↓
DTO prepares response data
      ↓
Response sent back to client
      ↓
Client displays data on UI
```
---

## Database Creation
The application uses an Oracle Database designed to support multi-user interactions, wishlists, contributions, and notifications.


## Entity Relationship Diagram (ERD)

### Designed to represent:

- Users
- Friend relationships
- Wishes (gifts)
- Contributions
- Notifications



## Database Schema

### A dedicated schema is created for the project

#### Tables include:

- USERS
- FRIENDSHIPS
- FRIEND REQUESTS
- WISH_ITEMS
- CONTRIBUTIONS
- NOTIFICATIONS

#### Each table:

- Uses a primary key ID
- Applies foreign key constraints to maintain data integrity
- Supports cascading rules where needed


## ID Management & Triggers

### Each table has:

- A sequence for ID generation
- A BEFORE INSERT trigger to automatically assign IDs

### Benefits

- Ensures unique IDs
- Prevents manual ID handling
- Maintains consistency across all tables
  

## Database Technology

- Database: Oracle Database
- Language: SQL & PL/SQL
- Connection: JDBC (handled via DBConnection helper on server side)
  

## Database Access

- All database operations are executed only on the server side
- Client side never accesses the database directly
- Communication occurs via socket requests
---

## Features
### Server Side

- Start server (connects to database)
- Stop server (disconnects from database)
- Handle multiple clients concurrently


### Client Side

- Register / Log In
- Log in with multiple users at the same time
- Create a personal wishlist:
    - Name
    - Price
    - Description

- View all users in the application
- Send friend requests
- Accept or decline friend requests
- Remove friends
- View friends’ wishlists
- Contribute to any wish
- Notifications system:
    - Contributor: notified when a gift is completed
    - Wish Owner:
        - notified on each contribution
        - notified when the gift is completed
- Edit wishlist description
- Home page dashboard:
    - Number of users
    - Number of wishes
    - Total contributions
    - Unread notifications count
- Contributions details:
    - Contributor name
    - Contribution percentage
    - Item name
    - Contributed amount
---

## How to Run the Project

- Run Server Side
- Click Start Server
- Run Client Side
- Open multiple clients simultaneously
- Stop the server at any time
→ Database data will no longer be accessible
---

## Notes

- Supports multi-client connections
- Uses DTOs to control displayed data per user
- Socket-based communication ensures real-time interaction
- Clean separation of concerns using layered architecture
---



