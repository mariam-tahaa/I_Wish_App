# 🎁 Client–Server Wishlist Application

A **JavaFX client–server application** built using **Java, JavaFX, SQL, and PL/SQL**, following a **layered architecture** with **socket-based communication**.  
The system allows multiple users to manage wishlists, contribute to gifts, and interact socially through friend requests and notifications.

---

## 🛠 Technologies Used

- Java
- JavaFX
- Socket Programming
- SQL / PL-SQL
- Oracle Database
- MVC + Layered Architecture

---

## 🏗 Project Architecture

The project follows a **Client–Server architecture**, where the **client communicates with the server using sockets**.

---

## 📁 Project Structure

### 🔹 Client Side

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
│   └── UserContext
│       └── Determines which user's data is displayed
│
└── ui/
    └── JavaFX views (FXML files)

