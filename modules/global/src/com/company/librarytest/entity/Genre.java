package com.company.librarytest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "LIBRARYTEST_GENRE")
@Entity(name = "librarytest$Genre")
public class Genre extends StandardEntity {
    private static final long serialVersionUID = -2372363048725091217L;

    @Column(name = "STATE")
    protected Integer state;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @JoinTable(name = "LIBRARYTEST_GENRE_BOOK_LINK",
        joinColumns = @JoinColumn(name = "GENRE_ID"),
        inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    @ManyToMany
    protected List<Book> bookCollection;

    public void setState(State state) {
        this.state = state == null ? null : state.getId();
    }

    public State getState() {
        return state == null ? null : State.fromId(state);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBookCollection(List<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    public List<Book> getBookCollection() {
        return bookCollection;
    }


}