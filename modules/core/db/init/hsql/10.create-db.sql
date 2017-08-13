-- begin LIBRARYTEST_BOOK
create table LIBRARYTEST_BOOK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    STATE integer,
    NAME varchar(255) not null,
    AUTHOR_ID varchar(36),
    YEAR_ integer,
    EDITION varchar(100),
    --
    primary key (ID)
)^
-- end LIBRARYTEST_BOOK
-- begin LIBRARYTEST_GENRE
create table LIBRARYTEST_GENRE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    STATE integer,
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end LIBRARYTEST_GENRE
-- begin LIBRARYTEST_AUTHOR
create table LIBRARYTEST_AUTHOR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    STATE integer,
    LAST_NAME varchar(100) not null,
    FIRST_NAME varchar(100),
    MIDDLE_NAME varchar(255),
    --
    primary key (ID)
)^
-- end LIBRARYTEST_AUTHOR
-- begin LIBRARYTEST_GENRE_BOOK_LINK
create table LIBRARYTEST_GENRE_BOOK_LINK (
    GENRE_ID varchar(36) not null,
    BOOK_ID varchar(36) not null,
    primary key (GENRE_ID, BOOK_ID)
)^
-- end LIBRARYTEST_GENRE_BOOK_LINK
