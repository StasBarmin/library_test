alter table LIBRARYTEST_GENRE_BOOK_LINK add constraint FK_LGBL_GENRE foreign key (GENRE_ID) references LIBRARYTEST_GENRE(ID);
alter table LIBRARYTEST_GENRE_BOOK_LINK add constraint FK_LGBL_BOOK foreign key (BOOK_ID) references LIBRARYTEST_BOOK(ID);
