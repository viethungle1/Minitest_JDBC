package com.example.minitest_3table.service.category;

import com.example.minitest_3table.model.Book;
import com.example.minitest_3table.model.Category;
import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO {
    List<Category> showList();
    void addCategory(Category category);
    void deleteCategory(int id) throws SQLException;
}
