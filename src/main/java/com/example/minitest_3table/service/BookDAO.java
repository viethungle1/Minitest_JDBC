package com.example.minitest_3table.service;
import com.example.minitest_3table.model.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/minitest_3table";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "123456";
    private static final String INSERT_INTO_BOOK = "insert into book (name, author, description) value (?, ?, ?);";
    private static final String SELECT_ALL_BOOK = "select * from book;";
    private static final String UPDATE_BOOK = "update book set name=?, author=?, description=? where id=?;";
    private static final String SELECT_FROM_BOOK = "select * from book where id=?;";
    private static final String DELETE_FROM_BOOK = "delete from book where id=?;";

    protected Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }
    private void printSQLException(SQLException e) {
    }

    @Override
    public List<Book> showList() {
        List<Book> bookList = new ArrayList<>();
        Connection c = getConnection();
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
            throw new RuntimeException(e);
        }
        return bookList;
    }

    @Override
    public void addBook(Book book) {
        Connection c = getConnection();
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
        Connection c = getConnection();
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
        Connection c = getConnection();
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
        Connection c = getConnection();
        try {
            PreparedStatement statement = c.prepareStatement(DELETE_FROM_BOOK);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
