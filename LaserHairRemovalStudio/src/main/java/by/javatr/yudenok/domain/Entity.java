package by.javatr.yudenok.domain;

public class Entity {
    /**
     * unique identifying field.
     */
    private Integer id;

    /**
     * copy constructor.
     * @param id identify number
     */
    public Entity(Integer id) {
        this.id = id;
    }

    /**
     * default constructor.
     */
    public Entity() {
    }

    /**
     * standart getter.
     * @return identify number
     */
    public Integer getId() {
        return id;
    }

    /**
     * standart setter.
     * @param id identify number
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Overriding object method.
     * @param o compared object
     * @return true/false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return id != null ? id.equals(entity.id) : entity.id == null;

    }

    /**
     * object overriding method.
     * @return number object representation
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
