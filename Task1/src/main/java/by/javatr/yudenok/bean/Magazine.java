package by.javatr.yudenok.bean;

public class Magazine {
    private Author author;
    private String title;
    private int pagesAmount;
    private String publishingHouseName;

    public Magazine(Author author, String title, int pagesAmount, String publishingHouseName) {
        this.author = author;
        this.title = title;
        this.pagesAmount = pagesAmount;
        this.publishingHouseName = publishingHouseName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPagesAmount() {
        return pagesAmount;
    }

    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }

    public String getPublishingHouseName() {
        return publishingHouseName;
    }

    public void setPublishingHouseName(String publishingHouseName) {
        this.publishingHouseName = publishingHouseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Magazine magazine = (Magazine) o;

        if (pagesAmount != magazine.pagesAmount) return false;
        if (author != null ? !author.equals(magazine.author) : magazine.author != null) return false;
        if (title != null ? !title.equals(magazine.title) : magazine.title != null) return false;
        return publishingHouseName != null ? publishingHouseName.equals(magazine.publishingHouseName) : magazine.publishingHouseName == null;

    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + pagesAmount;
        result = 31 * result + (publishingHouseName != null ? publishingHouseName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Magazine :\n" +
                author +
                "title : " + title +
                "\npagesAmount : " + pagesAmount +
                "\npublishingHouseName : " + publishingHouseName + '\n';
    }
}
