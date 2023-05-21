package com.bhusha.bookManager;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class BookController {

    Map<Integer, Book> bookData = new HashMap<>();

    @PostMapping("/add-new-book")
    public String addBook(@RequestBody Book book) {
        bookData.put(book.getId(), book);
        return "book created with id:" + book.getId();
    }

    @GetMapping("/get-book")
    public Book getBook(@RequestParam Integer id) {
        return bookData.get(id);
    }

    @GetMapping("/get-all-books")
    public List<Book> getAllBooks() {
        return new ArrayList(bookData.values());
    }

    @GetMapping("/get-book-by-name/{name}")
    public Book getBookByName(@PathVariable String name) {
        for (Map.Entry<Integer, Book> entry : bookData.entrySet()) {
            if (entry.getValue().getTitle().equals(name))
                return entry.getValue();
        }
        return null;
    }
    @PutMapping("/update-book-pages")

    public Book updateBookPages(@RequestParam Integer id,@RequestParam Integer pages){
        Book book=bookData.get(id);
        book.setPages(pages);
        bookData.put(id,book);
        return book;

    }
    @DeleteMapping("/delete-book")
    public String deleteBook(@RequestParam Integer id){
        bookData.remove(id);
        return ("book deleted with id:"+id);
    }
}
