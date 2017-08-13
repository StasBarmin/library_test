package com.company.librarytest.web.book;

import com.company.librarytest.entity.Book;
import com.company.librarytest.web.components.ImportBooksAction;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Table;

import javax.inject.Inject;
import java.util.Map;

public class BookBrowse extends AbstractLookup {

    @Inject
    private Table<Book> booksTable;

    @Override
    public void init(Map<String, Object> params) {
        addAction(new ImportBooksAction(booksTable));
    }
}