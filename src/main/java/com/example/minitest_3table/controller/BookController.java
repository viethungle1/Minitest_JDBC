package com.example.minitest_3table.controller;
import com.example.minitest_3table.model.Book;
import com.example.minitest_3table.service.book.BookDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet (urlPatterns = "/book")
public class BookController extends HttpServlet {
    private BookDAO bookDAO;
    public void init() {
        bookDAO = new BookDAO();
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
                case "edit":
                    showEditForm(req, resp);
                    break;
                case "delete":
                    deleteBook(req, resp);
                    break;
                default:
                    bookList(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookDAO.deleteBook(id);
        List<Book> bookList = bookDAO.showList();
        req.setAttribute("list",bookList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/list.jsp");
        dispatcher.forward(req,resp);
    }
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("book",bookDAO.selectBook(id));
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/edit.jsp");
        dispatcher.forward(req,resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/create.jsp");
        dispatcher.forward(req,resp);
    }

    private void bookList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = bookDAO.showList();
        req.setAttribute("list",bookList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/list.jsp");
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
                createNewBook(req,resp);
                break;
            case "edit":
                updateBook(req,resp);
                break;
        }
    }
    private void updateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String description = req.getParameter("description");
        Book book = new Book(id,name,author,description);
        bookDAO.updateBook(book);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/edit.jsp");
        dispatcher.forward(req,resp);
    }
    private void createNewBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String description = req.getParameter("description");
        Book book = new Book(name,author,description);
        bookDAO.addBook(book);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/create.jsp");
        dispatcher.forward(req,resp);
    }
}
