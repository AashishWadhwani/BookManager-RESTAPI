package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //private static List<Book> list = new ArrayList<>();

//    static{
//        list.add(new Book(12,"Java Complete Reference", "XYZ"));
//        list.add(new Book(36,"Java 8", "ABC"));
//        list.add(new Book(53,"Java Collections", "DEF"));
//    }

    //get all books
    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>)this.bookRepository.findAll();
        return list;
    }

    //get single book by id
    public Book getBookById(int id){
        Book book = null;
        try {
            //book = list.stream().filter(e -> e.getId() == id).findFirst().get();

            book=this.bookRepository.findById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //adding the book
    public Book addBook(Book b){
        //list.add(b);

        Book result = bookRepository.save(b);
        return result;
    }

    //delete the book
    public void deleteBook(int bid){
        //list = list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    //update the book
    public void updateBook(Book book,int bookId){
//        list = list.stream().map(b->{
//            if(b.getId()==bookId)
//            {
//                b.setTitle(book.getTitle());
//                b.setAuthor(book.getAuthor());
//            }
//            return b;
//        }).collect(Collectors.toList());

        book.setId(bookId);
        bookRepository.save(book);
    }
}
