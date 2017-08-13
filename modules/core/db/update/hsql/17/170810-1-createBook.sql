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
);
