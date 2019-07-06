package by.javatr.yudenok.domain;

public class Account extends Entity {
    /**
     * string field (users login).
     */
    private String login;
    /**
     * string field (users password).
     */
    private String password;

    /**
     * copy constructor
     * @param login
     * @param password
     */
    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * default constructor.
     */
    public Account() {

    }

    /**
     * standart field getter.
     * @return login string field
     */
    public String getLogin() {
        return login;
    }

    /**
     * standart field setter.
     * @param login string field
     */
    public void setLogin(final String login) {
        this.login = login;
    }

    /**
     * standart field getter.
     * @return password string field
     */
    public String getPassword() {
        return password;
    }

    /**
     * standart field setter.
     * @param password string field
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * object overriding method.
     * @param o compared object
     * @return true/false
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (login != null ? !login.equals(account.login)
                : account.login != null) {
            return false;
        }
        return password != null ? password.equals(account.password)
                : account.password == null;
    }

    /**
     * object overriding method.
     * @return number object representation
     */
    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    /**
     * object overriding method.
     * @return object string representation
     */
    @Override
    public String toString() {
        return "Account{"
                + "login='"
                + login + '\''
                + ", password='" + password + '\''
                + '}';
    }
}
