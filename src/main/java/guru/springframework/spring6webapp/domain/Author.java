package guru.springframework.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @ManyToMany(mappedBy = "authors")
    Set<Book> books = new HashSet<>();

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long Id;
    String FirstName;
    String LastName;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "books=" + books +
                ", Id=" + Id +
                ", Name='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Objects.equals(Id, author.Id);
    }

    @Override
    public int hashCode() {
        return Id != null ? Id.hashCode() : 0;
    }
}
