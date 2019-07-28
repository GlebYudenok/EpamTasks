package by.javatr.yudenok.controller;

import by.javatr.yudenok.domain.User;
import by.javatr.yudenok.exception.IncorrectFormDataException;
import by.javatr.yudenok.service.UserSignUpService;
import by.javatr.yudenok.validator.Validator;
import by.javatr.yudenok.validator.ValidatorFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class SignUp extends HttpServlet {

    private static final Logger LOGGER =
            LogManager.getLogger(SignUp.class);

    private static final UserSignUpService service = new UserSignUpService();
    private static final Validator<User> validator = ValidatorFactory.createValidator(User.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        User user = null;

        try {
            validator.validate(request);
        } catch (IncorrectFormDataException e) {
            e.printStackTrace();
            pw.println("Error");
        }

        try {
            user = service.signUp(request.getParameter("login"),
                    request.getParameter("pass"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (validator.isNull(user)) {
            pw.println("Пользователь ввел неверные данные");
            throw new NullPointerException("Ползатель ввел неверные данные");
        }

        pw.println("<html><body>" +
                "<h1>" + user + "</h1></body></html>");
        LOGGER.info("Sign up execute successfully.");
    }
}
