package com.example.minitest_3table.service.category;

import com.example.minitest_3table.config.ConnectionJDBC;
import com.example.minitest_3table.model.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CategoryDAO implements ICategoryDAO {
    public static final String INSERT_INTO_CATEGORY = "insert into category(name,description) values(?,?);";
    public static final String SELECT_ALL_CATEGORY = "select * from category;";
    public static final String DELETE_FROM_CATEGORY = "delete from category where id=?;";
    public static final String SELECT_CATEGORY_BY_BOOKID = "select c.id, c.name, c.description from category c join book_category bc on c.id = bc.id_category and bc.id_book=?;";
    Connection c = ConnectionJDBC.getConnection();
    private void printSQLException(SQLException e) {
    }
    @Override
    public List<Category> showList() {
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                categoryList.add(new Category(id,name,description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoryList;
    }

    @Override
    public void addCategory(Category category) {
        try {
            PreparedStatement statement = c.prepareStatement(INSERT_INTO_CATEGORY);
            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    @Override
    public void deleteCategory(int id) throws SQLException {
        try {
            PreparedStatement statement = c.prepareStatement(DELETE_FROM_CATEGORY);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
    @Override
    public List<Category> findAllByBookId(int id_book) {
        List<Category> categories = new ArrayList<>();
        try{
            PreparedStatement statement = c.prepareStatement(SELECT_CATEGORY_BY_BOOKID);
            statement.setInt(1,id_book);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Category category = new Category(id,name,description);
                categories.add(category);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categories;
    }
}
