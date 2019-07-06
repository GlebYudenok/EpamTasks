package by.javatr.yudenok.domain;

public enum Role {
    /**
     * administrator role.
     */
    ADMIN("admin"),
    /**
     * matser role.
     */
    MASTER("master"),
    /**
     * user role.
     */
    USER("user");

    /**
     * String field, which define role as string.
     */
    private String name;

    /**
     * constructor.
     * @param name field
     */
    private Role(final String name) {
        this.name = name;
    }

    /**
     * standart getter.
     * @return string field
     */
    public String getName() {
        return name;
    }

    /**
     * standart getter.
     * @return identify number
     */
    public Integer getId() {
        return ordinal();
    }

    /**
     * get value by identify number.
     * @param id identify number
     * @return id
     */
    public static Role getById(final Integer id) {
        return Role.values()[id];
    }

    /**
     * object string representation.
     * @return object as string
     */
    @Override
    public String toString() {
        return "Role{"
                + "name='" + name + '\''
                + '}';
    }
}
