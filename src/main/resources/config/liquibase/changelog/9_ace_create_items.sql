create table items
(
  id                 uuid not null primary key,
  sku_barcode        varchar,
  stock_code         varchar,
  brand              varchar,
  item_name        varchar,
  unit_cost          numeric,
  initial_markup     numeric,
  usage_unit         varchar,
  purchase_unit      varchar,
  conversion_qty     int,

  created_by         varchar(50),
  created_date       timestamp(6) default CURRENT_TIMESTAMP,
  last_modified_by   varchar(50),
  last_modified_date timestamp(6) default CURRENT_TIMESTAMP,
  deleted            boolean
);
