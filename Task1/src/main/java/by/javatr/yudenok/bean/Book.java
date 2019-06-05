package by.javatr.yudenok.bean;

public class Book {
    private Author author;
    private int pagesAmount;
    private String title;
    private int writtingYear;
    private BookGenre genre;

    public Book(Author author, String title, BookGenre genre, int writtingYear, int pagesAmount) {
        this.author = author;
        this.pagesAmount = pagesAmount;
        this.title = title;
        this.writtingYear = writtingYear;
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPagesAmount() {
        return pagesAmount;
    }

    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWrittingYear() {
        return writtingYear;
    }

    public void setWrittingYear(int writtingYear) {
        this.writtingYear = writtingYear;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (pagesAmount != book.pagesAmount) return false;
        if (writtingYear != book.writtingYear) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        return genre == book.genre;

    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + pagesAmount;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + writtingYear;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book :\n" +
                author +
                "title : " + title + '\n' +
                "genre : " + genre + '\n' +
                "writtingYear : " + writtingYear +
                "\npagesAmount : " + pagesAmount + '\n';


    }
}
