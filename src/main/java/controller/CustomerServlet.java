package controller;

import model.Customer;
import service.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static java.nio.file.Files.delete;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            default:
                showListCustomer(request, response);
                break;

        }


    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("danhSach" ,customers);
        request.getRequestDispatcher("customer/list.jsp").forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("delete", customer);
        request.getRequestDispatcher("customer/delete.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("edit", customer);
        request.getRequestDispatcher("customer/update.jsp").forward(request, response);

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("customer/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age= Integer.parseInt(request.getParameter("age"));
        customerService.save(new Customer(id, name, age));
        response.sendRedirect("/customers");

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        customerService.update(id, new Customer(id, name, age));

        response.sendRedirect("/customers");

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        response.sendRedirect("/customers");
    }
}
