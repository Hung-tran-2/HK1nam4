package stu.edu.restapi.model;

public class Book {
    private String isbn; //mã số cuốn sách
    private String title;//tiêu đề cuốn sách
    private String author; //tác giả cuốn sách
    private int edition;   //lần suất bản;
    private int publisheYear; //năm xuat bản
    //private byte[] imagel;

    public Book() {
    }

    public Book(String isbn, String title, String author, int edition, int publisheYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.publisheYear = publisheYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getPublisheYear() {
        return publisheYear;
    }

    public void setPublisheYear(int publisheYear) {
        this.publisheYear = publisheYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", edition=" + edition +
                ", publisheYear=" + publisheYear +
                '}';
    }
}
