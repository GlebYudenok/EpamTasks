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
        Account account;
        AccountValidator accountValidator = new AccountValidator();

        String parameter = request.getParameter("id");
        if(parameter != null) {
            try {
                user.setId(Integer.parseInt(parameter));
            } catch(NumberFormatException e) {
                throw new IncorrectFormDataException();
            }
        }

        account = accountValidator.validate(request);

        user.setAccount(account);

        parameter = request.getParameter("role");

        if(noRowInDB(user.getId()))
        {
            throw new IncorrectFormDataException();
        }
        return user;
    }

    public boolean noRowInDB(Integer id){
        if(id != null){
            return false;
        }
        return true;
    }
}
