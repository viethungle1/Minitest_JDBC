package com.example.minitest_3table.service.book_category;
import com.example.minitest_3table.model.Book;
import com.example.minitest_3table.model.BookCategory;

import java.sql.SQLException;
import java.util.List;
public interface IBookCategoryDAO {
    List<BookCategory> showList() throws SQLException;
    void addBookCategory(BookCategory cbook);
    void deleteBookCategory(int id) throws SQLException;
}
