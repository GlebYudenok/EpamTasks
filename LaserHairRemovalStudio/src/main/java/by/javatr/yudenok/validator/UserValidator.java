package by.javatr.yudenok.validator;

import by.javatr.yudenok.domain.Account;
import by.javatr.yudenok.domain.Role;
import by.javatr.yudenok.domain.User;
import by.javatr.yudenok.exception.IncorrectFormDataException;

import javax.servlet.http.HttpServletRequest;

public class UserValidator implements Validator<User>{

    @Override
    public User validate(HttpServletRequest request) throws IncorrectFormDataException {
        User user = new User();

        Account account = new Account();
        String parameter = request.getParameter("login");
        if(correctAccountData(parameter)) {
            account.setLogin(parameter);
        }else {
            throw new IncorrectFormDataException();
        }
        parameter = request.getParameter("pass");
        if(correctAccountData(parameter)){
            account.setPassword(parameter);
        }else {
            throw new IncorrectFormDataException();
        }
        user.setAccount(account);
        return user;
    }

    private boolean correctAccountData(String parameter) throws IncorrectFormDataException {
        if(parameter != null && !parameter.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNull(User user){
        if(user == null)
            return true;
        return false;
    }
}
