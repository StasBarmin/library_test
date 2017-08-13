package com.company.librarytest.web.components;

import com.company.librarytest.entity.Book;
import com.company.librarytest.web.book.BookImport;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.*;



/**
 * Created by Stas on 13.08.2017.
 */
public class ImportBooksAction extends com.haulmont.cuba.gui.components.AbstractAction{

    private Table<Book> booksTable;

    public ImportBooksAction(Table<Book> booksTable) {
        super("importBooks");
        this.booksTable = booksTable;
    }

    @Override
    public void actionPerform(Component component) {
        Frame frame = booksTable.getFrame();

            final BookImport bookImportWindow = (BookImport) frame.openWindow("book-import",
                    WindowManager.OpenType.DIALOG.width(400));
        bookImportWindow.addListener(actionId -> {
                if (BookImport.SUCCESS_ACTION.equals(actionId)) {
//                    for (BookInstance assignedInstance : bookImportWindow.getAssignedInstances()) {
//                        // Put returned instances back into datasource
//                        booksTable.getDatasource().updateItem(assignedInstance);
//                    }
                    booksTable.getDatasource().refresh();
                }
            });

    }
}
