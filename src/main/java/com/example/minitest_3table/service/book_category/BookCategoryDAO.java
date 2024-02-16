package com.example.minitest_3table.service.book_category;
import com.example.minitest_3table.config.ConnectionJDBC;
import com.example.minitest_3table.model.BookCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCategoryDAO implements IBookCategoryDAO {
    Connection c = ConnectionJDBC.getConnection();
    private void printSQLException(SQLException e) {
    }
    @Override
    public List<BookCategory> showList() {
        List<BookCategory> list = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement("select * from book_category;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id_book = rs.getInt("id_book");
                int id_category = rs.getInt("id_category");
                list.add(new BookCategory(id_book,id_category));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } return list;
    }

    @Override
    public void addBookCategory(BookCategory cbook) {
        try {
            PreparedStatement statement = c.prepareStatement("insert into book_category(id_book,id_category) values (?,?);");
            statement.setInt(1,cbook.getId_book());
            statement.setInt(2,cbook.getId_category());
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void deleteBookCategory(int id) throws SQLException {
        try {
            PreparedStatement statement = c.prepareStatement("delete from book_category where id=?;");
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

    }
}
