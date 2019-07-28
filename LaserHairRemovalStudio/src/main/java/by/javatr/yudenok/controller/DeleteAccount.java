package by.javatr.yudenok.controller;

import by.javatr.yudenok.domain.User;
import by.javatr.yudenok.service.AccountDeleteService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class DeleteAccount extends HttpServlet {

    private static final AccountDeleteService service =
            new AccountDeleteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        try {
            service.delete(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter pw = resp.getWriter();
        pw.println("Account was deleted");
    }
}
