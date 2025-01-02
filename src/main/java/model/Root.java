package model;

import jakarta.xml.bind.annotation.*;

import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {
    @XmlElementWrapper
    @XmlElement(name = "book")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Root{" +
                "books=" + books +
                '}';
    }
}
