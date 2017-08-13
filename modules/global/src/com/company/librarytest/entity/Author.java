package com.company.librarytest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s|lastName,firstName")
@Table(name = "LIBRARYTEST_AUTHOR")
@Entity(name = "librarytest$Author")
public class Author extends StandardEntity {
    private static final long serialVersionUID = -6022883706944889524L;

    @Column(name = "STATE")
    protected Integer state;

    @Column(name = "LAST_NAME", nullable = false, length = 100)
    protected String lastName;

    @Column(name = "FIRST_NAME", length = 100)
    protected String firstName;

    @Column(name = "MIDDLE_NAME")
    protected String middleName;

    @OneToMany(mappedBy = "author")
    protected List<Book> bookCollection;

    public void setState(State state) {
        this.state = state == null ? null : state.getId();
    }

    public State getState() {
        return state == null ? null : State.fromId(state);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setBookCollection(List<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    public List<Book> getBookCollection() {
        return bookCollection;
    }


}