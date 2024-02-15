package com.example.minitest_3table.controller;


import com.example.minitest_3table.model.Book;
import com.example.minitest_3table.model.Category;
import com.example.minitest_3table.service.category.CategoryDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns ="/category")
public class CategoryServlet extends HttpServlet {
    private CategoryDAO categoryDAO;
    public void init() {
        categoryDAO = new CategoryDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(req, resp);
                    break;
                case "delete":
                    deleteCategory(req, resp);
                    break;
                default:
                    categoryList(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        categoryDAO.deleteCategory(id);
        List<Category> categoryList = categoryDAO.showList();
        req.setAttribute("list",categoryList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("category/list.jsp");
        dispatcher.forward(req,resp);
    }

    private void categoryList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = categoryDAO.showList();
        req.setAttribute("list",categoryList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("category/list.jsp");
        dispatcher.forward(req,resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("category/create.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewCategory(req,resp);
                break;
        }
    }

    private void createNewCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Category category = new Category(name,description);
        categoryDAO.addCategory(category);
        RequestDispatcher dispatcher = req.getRequestDispatcher("category/create.jsp");
        dispatcher.forward(req,resp);
    }
}
