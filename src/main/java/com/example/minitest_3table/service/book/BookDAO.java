package com.example.minitest_3table.service.book;
import com.example.minitest_3table.config.ConnectionJDBC;
import com.example.minitest_3table.model.Book;
import com.example.minitest_3table.model.Category;
import com.example.minitest_3table.service.category.CategoryDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BookDAO implements IBookDAO {
    private static final String INSERT_INTO_BOOK = "insert into book (name, author, description) value (?, ?, ?);";
    private static final String SELECT_ALL_BOOK = "select * from book;";
    private static final String UPDATE_BOOK = "update book set name=?, author=?, description=? where id=?;";
    private static final String SELECT_FROM_BOOK = "select * from book where id=?;";
    private static final String DELETE_FROM_BOOK = "delete from book where id=?;";
    CategoryDAO categoryDAO = new CategoryDAO();
    Connection c = ConnectionJDBC.getConnection();
    private void printSQLException(SQLException e) {
    }
    @Override
    public List<Book> showList() {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement(SELECT_ALL_BOOK);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                bookList.add(new Book(id,name,author,description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bookList;
    }

    @Override
    public void addBook(Book book) {
        try {
            PreparedStatement statement = c.prepareStatement(INSERT_INTO_BOOK);
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void updateBook(Book book) {
        try {
            PreparedStatement statement = c.prepareStatement(UPDATE_BOOK);
            statement.setString(1,book.getName());
            statement.setString(2,book.getAuthor());
            statement.setString(3,book.getDescription());
            statement.setInt(4,book.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Book selectBook(int id) {
        Book book = null;
        try {
            PreparedStatement statement = c.prepareStatement(SELECT_FROM_BOOK);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                book = new Book(name,author,description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return book;
    }

    @Override
    public void deleteBook(int id) throws SQLException {
        try {
            PreparedStatement statement = c.prepareStatement(DELETE_FROM_BOOK);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement(SELECT_ALL_BOOK);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                List<Category> category = categoryDAO.findAllByBookId(id);
                Book book = new Book(id,name,author,description,category);
                bookList.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }
}
