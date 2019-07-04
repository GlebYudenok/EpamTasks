package by.javatr.yudenok.validator;

import by.javatr.yudenok.domain.Account;
import by.javatr.yudenok.domain.User;
import by.javatr.yudenok.exception.IncorrectFormDataException;

import javax.servlet.http.HttpServletRequest;

public class AccountValidator implements Validator<Account> {
    @Override
    public Account validate(HttpServletRequest request) throws IncorrectFormDataException {
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

        return account;
    }

    private boolean correctAccountData(String parameter) throws IncorrectFormDataException {
        if(parameter != null && !parameter.isEmpty()) {
            return true;
        }
        return false;
    }
}
