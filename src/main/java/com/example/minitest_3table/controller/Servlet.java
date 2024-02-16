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
import java.util.List;

@WebServlet(urlPatterns="")
public class Servlet extends HttpServlet {
    BookDAO bookDAO = new BookDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            default:
                showMenu(req, resp);
        }
    }
    private void showMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = bookDAO.findAll();
        req.setAttribute("list",bookList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req,resp);
    }

}
