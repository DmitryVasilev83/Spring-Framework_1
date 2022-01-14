package ru.geekbrains.servlet;

import ru.geekbrains.model.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "CatHTTPServlet", urlPatterns = "/cat")

public class CatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cat", getCat());
        getServletContext().getRequestDispatcher("/cat.jsp").forward(req, resp);
    }

    private Cat getCat(){
        List<Cat> cats = Arrays.asList(
                new Cat("Mursik", 1, null),
                new Cat("Snezhok", 1, null)
        );
        return new Cat("Barsik", 3, cats);
    }
}
