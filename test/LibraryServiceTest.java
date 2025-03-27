package test;

import models.Book;
import services.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest{
	private LibraryService libraryService;

	@BeforeEach
	void setUp(){
		libraryService = new LibraryService();
	}

	@Test 
	void testAddBook(){
		assertTrue(libraryService.addBook("1","java programming","manish", "Technology"));
		assertFalse(libraryService.addBook("1","Duplicate book","jay","Fiction"));
	}

	@Test 
	void testSearchBook(){
		libraryService.addBook("2","clean code","maish","programming");
		Book book = libraryService.searchBook("clean code");
		assertNotNull(book);
		assertEquals("clean code",book.getTitle());
	}

	@Test 
	void testUpdateBook(){
		libraryService.addBook("3","python basics","manish","programming");
		assertTrue(libraryService.updateBook("3","python advanced","ramesh","programming","checked out"));

		Book book = libraryService.searchBook("3");
			assertEquals("python advanced",book.getTitle());
			assertEquals("checked out", book.getAvailabilityStatus());
	}

	@Test
	void testDeleteBook(){
		libraryService.addBook("4","Data structures","ritesh","cs");
			assertTrue(libraryService.deleteBook("4"));
			assertNull(libraryService.searchBook("4"));
	}
}