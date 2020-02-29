alter table items
    add column "category" uuid;

alter table items
    add constraint "fk_items_category"
    foreign key ("category")
    references categories ("id")
    on update cascade on delete restrict;