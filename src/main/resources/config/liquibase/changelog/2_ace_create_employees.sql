create table employees
(
  id                             uuid not null primary key,
  employee_no                    varchar,
  first_name                     varchar,
  last_name                      varchar,
  middle_name                    varchar,
  gender                         varchar,
  dob                            date,

  created_by                     varchar(50),
  created_date                   timestamp(6) default CURRENT_TIMESTAMP,
  last_modified_by               varchar(50),
  last_modified_date             timestamp(6) default CURRENT_TIMESTAMP,
  deleted                        boolean
);