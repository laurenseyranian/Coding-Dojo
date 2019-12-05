package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    // creates or edits a book and saves it
    public Book createOrEditBook(Book book) {
        return bookRepository.save(book);
        
    }
    // retrieves a book by id
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // updates a book by id
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book editBook = this.findBook(id);
		editBook.setTitle(title);
		editBook.setDescription(desc);
		editBook.setLanguage(lang);
		editBook.setNumberOfPages(numOfPages);
		bookRepository.save(editBook);
		return editBook;
	}
	
	// deletes a book by id
	public void deleteBook(Long id) {
		Book deleteBook = this.findBook(id);
		bookRepository.delete(deleteBook);
	}
}