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
);
