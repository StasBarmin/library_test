package com.company.librarytest.web.book;

import com.company.librarytest.service.ImportService;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.TextField;

import javax.inject.Inject;
import java.net.MalformedURLException;
import java.net.URL;

public class BookImport extends AbstractWindow {

    public static final String SUCCESS_ACTION = "success";

    @Inject
    private ImportService importService;

    @Inject
    private TextField URLfield;

    public void assign() {

        URL url = null;
        try {
            url = new URL(URLfield.getRawValue());
        } catch (MalformedURLException e) {
            showNotification(getMessage("Incorrect URL. Reenter, please"), NotificationType.HUMANIZED);
            e.printStackTrace();
        }
        if (url != null) {
            importService.doImport(url);
            close(SUCCESS_ACTION);
        } else {
            showNotification(getMessage("Enter the URL"), NotificationType.HUMANIZED);
        }
    }

    public void close() {
        close("");
    }
}