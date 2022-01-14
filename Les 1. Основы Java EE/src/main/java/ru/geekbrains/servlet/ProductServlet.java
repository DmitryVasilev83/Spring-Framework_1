package ru.geekbrains.servlet;

import ru.geekbrains.model.Cat;
import ru.geekbrains.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ProductHTTPServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", getProducts());
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
    }

    private List<Product> getProducts() {

        List<Product> products = Arrays.asList(
            new Product(1, "product1", 100),
            new Product(2, "product2", 200),
            new Product(3, "product3", 300),
            new Product(4, "product4", 400),
            new Product(5, "product5", 500),
            new Product(6, "product6", 600),
            new Product(7, "product7", 700),
            new Product(8, "product8", 800),
            new Product(9, "product9", 900),
            new Product(10, "product10", 1000)
        );

        return products;
    }

}


//  <% for(Product value : (List<Product>) ((Product)request.getAttribute("product")).getProducts()) { %>
//    <li>1</li>
//<% } %>