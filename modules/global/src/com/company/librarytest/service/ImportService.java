package com.company.librarytest.service;


import com.company.librarytest.entity.Book;

import java.net.URL;
import java.util.Collection;

public interface ImportService {

    String NAME = "librarytest_ImportService";

    void doImport(URL url);
}