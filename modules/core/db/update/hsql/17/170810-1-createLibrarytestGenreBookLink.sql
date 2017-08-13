create table LIBRARYTEST_GENRE_BOOK_LINK (
    GENRE_ID varchar(36) not null,
    BOOK_ID varchar(36) not null,
    primary key (GENRE_ID, BOOK_ID)
);
