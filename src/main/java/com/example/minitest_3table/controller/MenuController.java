package com.example.minitest_3table.controller;
import com.example.minitest_3table.model.Book;
import com.example.minitest_3table.service.book.BookDAO;
import com.example.minitest_3table.service.book_category.BookCategoryDAO;
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

@WebServlet(urlPatterns="")
public class MenuController extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    BookDAO bookDAO = new BookDAO();
    BookCategoryDAO bookCategoryDAO = new BookCategoryDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action="";
        }
        try {
            switch (action) {
                case "create":
                    showFormCreate(req, resp);
                    break;
                case "delete":
                    deleteInMenu(req, resp);
                default:
                    showMenu(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteInMenu(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookDAO.deleteByBookID(id);
        List<Book> bookList = bookDAO.showList();
        req.setAttribute("list",bookList);
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("menu/create.jsp");
        req.setAttribute("categories",categoryDAO.showList());
        dispatcher.forward(req,resp);
    }

    private void showMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = bookDAO.findAll();
        req.setAttribute("list",bookList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("menu/list.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action) {
            case "create":
                createNewBook(req, resp);
                break;
        }
    }

    private void createNewBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String description = req.getParameter("description");
        String [] categoriesStr = req.getParameterValues("categories");
        int [] categories = new int[categoriesStr.length];
        for (int i = 0; i < categoriesStr.length; i++) {
            categories[i] = Integer.parseInt(categoriesStr[i]);
        }
        Book book = new Book(name,author,description);
        bookDAO.save(book,categories);
        RequestDispatcher dispatcher = req.getRequestDispatcher("menu/create.jsp");
        dispatcher.forward(req,resp);
    }

}
