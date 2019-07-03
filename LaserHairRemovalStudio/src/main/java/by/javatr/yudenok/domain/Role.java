package by.javatr.yudenok.domain;

public enum Role {
    ADMIN("admin"),
    MASTER("master"),
    USER("user");

    private String name;

    private Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return ordinal();
    }

    public static Role getById(Integer id) {
        return Role.values()[id];
    }
}
