package frontend.controllers;

import backend.dto.ProductDTO;
import backend.entities.Product;
import frontend.models.ProductModel;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Controller", value = "/controller")
public class Controller extends HttpServlet {
    @Inject
    private ProductModel productModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("list_products") ){
            List<ProductDTO> products = productModel.getAllProducts();
            req.setAttribute("products", products);
            req.getRequestDispatcher("views/products.jsp").forward(req, resp);


        }
        else if(action.equalsIgnoreCase("add") ){
            req.getRequestDispatcher("views/add-product.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out1 = resp.getWriter();
        out1.println("Dô tới dôPst");

        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("add") ){
            PrintWriter out = resp.getWriter();
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String unit = req.getParameter("unit");
            String manufacturer = req.getParameter("manufacturer");
//            int status = Integer.parseInt(req.getParameter("status"));

            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setUnit(unit);
            product.setManufacturer(manufacturer);

            out.println(product);
            out.println(req.getParameter("status"));

        }


    }
}
