package com.example.minitest_3table.controller;
import com.example.minitest_3table.model.BookCategory;
import com.example.minitest_3table.service.book_category.BookCategoryDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/bookcategory")

public class BookCategoryController extends HttpServlet {
    private BookCategoryDAO bookCategoryDAO;
    public void init() {
        bookCategoryDAO = new BookCategoryDAO();
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
                    deleteBookCategory(req, resp);
                    break;
                default:
                    bookCategoryList(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void bookCategoryList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookCategory> list = bookCategoryDAO.showList();
        RequestDispatcher dispatcher = req.getRequestDispatcher("book_category/list.jsp");
        req.setAttribute("list",list);
        dispatcher.forward(req,resp);
    }

    private void deleteBookCategory(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookCategoryDAO.deleteBookCategory(id);
        List<BookCategory> list = bookCategoryDAO.showList();
        req.setAttribute("list",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book_category/list.jsp");
        dispatcher.forward(req,resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("book_category/create.jsp");
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
                createNewBookCategory(req,resp);
                break;
        }
    }

    private void createNewBookCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_book = Integer.parseInt(req.getParameter("id_book"));
        int id_category = Integer.parseInt(req.getParameter("id_category"));
        BookCategory bookCategory = new BookCategory(id_book,id_category);
        bookCategoryDAO.addBookCategory(bookCategory);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book_category/create.jsp");
        dispatcher.forward(req,resp);
    }
}
