package by.javatr.yudenok.controller;

import by.javatr.yudenok.domain.User;
import by.javatr.yudenok.exception.IncorrectFormDataException;
import by.javatr.yudenok.service.UserSignInService;
import by.javatr.yudenok.validator.Validator;
import by.javatr.yudenok.validator.ValidatorFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class SignIn extends HttpServlet {

    private static final UserSignInService service = new UserSignInService();
    private static final Validator<User> validator =
            ValidatorFactory.createValidator(User.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=Windows-1251");
        try {
            validator.validate(req);
        } catch (IncorrectFormDataException e) {
            e.printStackTrace();
        }
        User user = null;
        try {
            user = service.register(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter pw = resp.getWriter();
        pw.println("Добро пожаловать, " + user.getName() + " " + user.getSurname());
    }
}
