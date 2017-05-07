insert into order_table (order_id, actual_deliver_date, expect_deliver_date, order_status) values (1000000000, '2017-01-01', '2017-01-01', 'new');

insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000000, 'prod 1', 'unit 1', 1, 100)
insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000001, 'prod 2', 'unit 2', 1, 100)

insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000000, 5.02, 'hkg', 'hahah', 'g')
insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000001, 6.02, 'hkg', 'hahah', 'kg')

insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000000, '2017-01-01', '2017-01-01', 1000000000, 3000000000, '2017-01-01', 'New', 10000);
insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000001, '2017-01-01', '2017-01-01', 1000000000, 3000000001, '2017-01-01', 'New', 10000);

insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000000, 3000000000, 1, 5000000000)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000001, 3000000000, 2, 5000000001)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000002, 3000000001, 1, 5000000000)