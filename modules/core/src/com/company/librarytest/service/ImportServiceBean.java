package com.company.librarytest.service;

import com.company.librarytest.entity.Author;
import com.company.librarytest.entity.Book;
import com.company.librarytest.entity.Genre;
import com.haulmont.cuba.core.app.importexport.CollectionImportPolicy;
import com.haulmont.cuba.core.app.importexport.EntityImportExportService;
import com.haulmont.cuba.core.app.importexport.EntityImportExportServiceBean;
import com.haulmont.cuba.core.app.importexport.EntityImportView;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;

@Service(ImportService.NAME)
public class ImportServiceBean implements ImportService {


    @Override
    public void doImport(URL url) {

        StringBuilder response = new StringBuilder();

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\test\22.txt")));
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                response.append(responseLine);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EntityImportView importView = new EntityImportView(Book.class);
        importView.addLocalProperties();
        importView.addManyToManyProperty("genreCollection",new EntityImportView(Genre.class).addLocalProperties(),
                 CollectionImportPolicy.KEEP_ABSENT_ITEMS);
        importView.addManyToOneProperty("author", new EntityImportView(Author.class).addLocalProperties());

        EntityImportExportService entityImportExportService = new EntityImportExportServiceBean();
        entityImportExportService.importEntitiesFromJSON(response.toString(), importView);
    }
}