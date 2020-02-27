alter table employees
    add column "user" bigserial;

alter table employees
    add constraint "fk_employees_user"
    foreign key ("user")
    references t_user ("id")
    on update cascade on delete restrict;