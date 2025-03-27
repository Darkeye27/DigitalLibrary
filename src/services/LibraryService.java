package services;

import models.Book;
import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private final Map<String, Book> bookCollection = new HashMap<>();

    // Add a new book
    public boolean addBook(String bookId, String title, String author, String genre) {
        if (bookId.isEmpty() || title.isEmpty() || author.isEmpty()) return false;
        if (bookCollection.containsKey(bookId)) return false;

        bookCollection.put(bookId, new Book(bookId, title, author, genre, "Available"));
        return true;
    }

    // View all books
    public Map<String, Book> getAllBooks() {
        return bookCollection;
    }

    // Search book by ID or Title
    public Book searchBook(String idOrTitle) {
        return bookCollection.values().stream()
                .filter(book -> book.getBookId().equals(idOrTitle) || book.getTitle().equalsIgnoreCase(idOrTitle))
                .findFirst()
                .orElse(null);
    }

    // Update book details
    public boolean updateBook(String bookId, String title, String author, String genre, String status) {
        if (!bookCollection.containsKey(bookId)) return false;

        Book book = bookCollection.get(bookId);
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setAvailabilityStatus(status);
        return true;
    }

    // Delete a book
    public boolean deleteBook(String bookId) {
        return bookCollection.remove(bookId) != null;
    }
}
