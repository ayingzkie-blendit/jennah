create table departments
(
  id                 uuid not null primary key,
  department_name    varchar,
  department_code    varchar,

  created_by         varchar(50),
  created_date       timestamp(6) default CURRENT_TIMESTAMP,
  last_modified_by   varchar(50),
  last_modified_date timestamp(6) default CURRENT_TIMESTAMP,
  deleted            boolean
);
