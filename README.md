# 📚 Digital Library Book Management System

## 🚀 Overview
This is a **Java-based Digital Library Management System** that allows librarians to **add, search, update, and delete books**. It includes a **simple GUI** and follows **best coding practices**.

## 🎯 Features
✅ **Add Book** - Store book details (ID, Title, Author, Genre, Availability)  
✅ **View All Books** - List all books in the library  
✅ **Search Book** - Find a book by ID or Title  
✅ **Update Book** - Modify book details  
✅ **Delete Book** - Remove a book from the system  
✅ **User-Friendly GUI**  

## 🏗️ Tech Stack
- **Java** (JDK 21+)
- **JUnit** (for testing)

## 📂 Project Structure
```
📂 DigitalLibrary  
 ├── 📂 src  
 │   ├── 📂 models       # Book class  
 │   ├── 📂 services     # Business logic  
 │   ├── 📂 ui           # GUI components  
 │   ├── Main.java       # Entry point  
 ├── 📂 test  
 │   ├── LibraryServiceTest.java  # Unit tests  
 ├── README.md  
 ├── .gitignore  
```

## 📦 Installation
1️⃣ **Clone the repository**  
```sh
git clone https://github.com/your-repo/library-management.git
cd library-management
```

2️⃣ **Compile the code**  
```sh
javac Main.java
```

3️⃣ **Run the application**  
```sh
java Main
```

## ✅ Running Unit Tests
```sh
javac -cp .:junit-5.7.1.jar test/LibraryServiceTest.java
java -cp .:junit-5.7.1.jar org.junit.runner.JUnitCore test.LibraryServiceTest
```

---


