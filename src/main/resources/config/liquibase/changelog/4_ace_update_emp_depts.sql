alter table employees
    add column department uuid;

alter table employees
    add constraint "fk_employees_department"
    foreign key ("department")
    references departments ("id")
    on update cascade on delete restrict;