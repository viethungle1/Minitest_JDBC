package com.example.minitest_3table.service.book;
import com.example.minitest_3table.model.Book;
import java.sql.SQLException;
import java.util.List;

public interface IBookDAO {
    List<Book> showList();
    void addBook(Book book);
    Book selectBook(int id);
    void updateBook(Book book);
    void deleteBook(int id) throws SQLException;
    List<Book> findAll();
    public void save(Book book, int[] categories);
}
