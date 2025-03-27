package ui;

import models.Book;
import services.LibraryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;

public class LibraryUI {
    private final LibraryService libraryService = new LibraryService();

    public void showMenu() {
        while (true) {
            String option = JOptionPane.showInputDialog("""
                    Digital Library System
                    1. Add Book
                    2. View All Books
                    3. Search Book
                    4. Update Book
                    5. Delete Book
                    6. Exit
                    Enter choice:
                    """);

            switch (option) {
                case "1" -> addBook();
                case "2" -> viewBooks();
                case "3" -> searchBook();
                case "4" -> updateBook();
                case "5" -> deleteBook();
                case "6" -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
            }
        }
    }

    private void addBook() {
        String id = JOptionPane.showInputDialog("Enter Book ID:");
        String title = JOptionPane.showInputDialog("Enter Title:");
        String author = JOptionPane.showInputDialog("Enter Author:");
        String genre = JOptionPane.showInputDialog("Enter Genre:");

        boolean success = libraryService.addBook(id, title, author, genre);
        JOptionPane.showMessageDialog(null, success ? "Book added successfully!" : "Error: Invalid or duplicate Book ID.");
    }

    private void viewBooks() {
        StringBuilder booksList = new StringBuilder("Books in Library:\n");
        for (Map.Entry<String, Book> entry : libraryService.getAllBooks().entrySet()) {
            booksList.append(entry.getValue().toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, booksList.toString());
    }

    private void searchBook() {
        String query = JOptionPane.showInputDialog("Enter Book ID or Title:");
        Book book = libraryService.searchBook(query);
        JOptionPane.showMessageDialog(null, book != null ? book.toString() : "Book not found.");
    }

    private void updateBook() {
        String id = JOptionPane.showInputDialog("Enter Book ID to update:");
        String title = JOptionPane.showInputDialog("Enter new Title:");
        String author = JOptionPane.showInputDialog("Enter new Author:");
        String genre = JOptionPane.showInputDialog("Enter new Genre:");
        String status = JOptionPane.showInputDialog("Enter Availability (Available/Checked Out):");

        boolean success = libraryService.updateBook(id, title, author, genre, status);
        JOptionPane.showMessageDialog(null, success ? "Book updated successfully!" : "Book not found.");
    }

    private void deleteBook() {
        String id = JOptionPane.showInputDialog("Enter Book ID to delete:");
        boolean success = libraryService.deleteBook(id);
        JOptionPane.showMessageDialog(null, success ? "Book deleted successfully!" : "Book not found.");
    }
}
