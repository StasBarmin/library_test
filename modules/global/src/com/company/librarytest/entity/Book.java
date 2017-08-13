package com.company.librarytest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

@NamePattern("%s|name")
@Table(name = "LIBRARYTEST_BOOK")
@Entity(name = "librarytest$Book")
public class Book extends StandardEntity {
    private static final long serialVersionUID = 9117221634080396138L;

    @Column(name = "STATE")
    protected Integer state;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Lookup(type = LookupType.DROPDOWN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    protected Author author;

    @Column(name = "YEAR_")
    protected Integer year;

    @Column(name = "EDITION", length = 100)
    protected String edition;


    @JoinTable(name = "LIBRARYTEST_GENRE_BOOK_LINK",
        joinColumns = @JoinColumn(name = "BOOK_ID"),
        inverseJoinColumns = @JoinColumn(name = "GENRE_ID"))
    @ManyToMany
    protected List<Genre> genreCollection;

    public void setGenreCollection(List<Genre> genreCollection) {
        this.genreCollection = genreCollection;
    }

    public List<Genre> getGenreCollection() {
        return genreCollection;
    }


    public void setState(State state) {
        this.state = state == null ? null : state.getId();
    }

    public State getState() {
        return state == null ? null : State.fromId(state);
    }


    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getEdition() {
        return edition;
    }


}