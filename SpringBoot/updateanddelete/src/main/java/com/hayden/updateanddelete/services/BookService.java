package com.hayden.updateanddelete.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hayden.updateanddelete.models.Book;
import com.hayden.updateanddelete.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book updateBook(Long id, String title, String desc, String lang, int pages) {
    	Optional<Book> bookToUpdate = bookRepository.findById(id); // Find the book to update by id
    	if(!bookToUpdate.isPresent()) {
    		return null;
    	}
    	else {
    		Book updatedBook = bookToUpdate.get(); 
    		updatedBook.setTitle(title);
    		updatedBook.setDescription(desc);
    		updatedBook.setLanguage(lang);
    		updatedBook.setNumberOfPages(pages);
    		updatedBook.setUpdatedAt(new java.util.Date());
    		bookRepository.save(updatedBook);
    		return updatedBook;
    	}
    }
    
    public Book deleteBook(Long id) {
    	Optional<Book> findBook = bookRepository.findById(id);
    	if (!findBook.isPresent()) {
    		return null;
    	}
    	else {
    		bookRepository.deleteById(id);
    		System.out.println("Book deleted!");
    		return null;
    	}
    }
}
