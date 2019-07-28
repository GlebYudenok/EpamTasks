package by.javatr.yudenok.domain;

public class User extends Entity {
    /**
     * name of user.
     */
    private String name;
    /**
     * surname of user.
     */
    private String surname;
    /**
     * phone number of user.
     */
    private long phoneNumber;
    /**
     * account users data.
     */
    private Account account;
    /**
     * role of user.
     */
    private Role role;

    /**
     * default constructor.
     */
    public User() {

    }

    public User(Integer id, String name, String surname, long phoneNumber, Account account, Role role) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.account = account;
        this.role = role;
    }

    /**
     * superclass constructor.
     * @param id id
     */
    public User(final Integer id) {
        super(id);
    }

    /**
     * standart getter for name field.
     * @return name of user
     */
    public String getName() {
        return name;
    }

    /**
     * standart setter for name field.
     * @param name name of user
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * standart getter for surname field.
     * @return surname of user
     */
    public String getSurname() {
        return surname;
    }

    /**
     * standart setter for surname field.
     * @param surname surname of user
     */
    public void setSurname(final String surname) {
        this.surname = surname;
    }

    /**
     * standart getter for phone number field.
     * @return phone number of user
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * standart setter for phone number field.
     * @param phoneNumber phone number of user
     */
    public void setPhoneNumber(final long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * standart getter for account field.
     * @return account data of user
     */
    public Account getAccount() {
        return account;
    }

    /**
     * standart setter for account field.
     * @param account account data of user
     */
    public void setAccount(final Account account) {
        this.account = account;
    }

    /**
     * standart getter for role field.
     * @return role of user
     */
    public Role getRole() {
        return role;
    }

    /**
     * standart setter for role.
     * @param role role of user
     */
    public void setRole(final Role role) {
        this.role = role;
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

        User user = (User) o;

        if (phoneNumber != user.phoneNumber) {
            return false;
        }
        if (name != null ? !name.equals(user.name)
                : user.name != null) {
            return false;
        }
        if (surname != null ? !surname.equals(user.surname)
                : user.surname != null) {
            return false;
        }
        if (account != null ? !account.equals(user.account)
                : user.account != null) {
            return false;
        }
        return role == user.role;
    }

    /**
     * object overriding method.
     * @return number object representation
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    /**
     * object overriding method.
     * @return object string representation
     */
    @Override
    public String toString() {
        return "User{"
                + "id='" + getId() + '\''
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", phoneNumber=" + phoneNumber + '\''
                + ", account=" + account + '\''
                + ", role=" + role
                + '}';
    }
}
