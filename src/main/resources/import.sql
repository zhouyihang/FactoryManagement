insert into order_table (order_id, actual_deliver_date, expect_deliver_date, order_status) values (1000000000, '2017-01-01', '2017-01-01', 'new');
insert into order_table (order_id, actual_deliver_date, expect_deliver_date, order_status) values (1000000001, '2017-02-01', '2017-04-01', 'new');
insert into order_table (order_id, actual_deliver_date, expect_deliver_date, order_status) values (1000000002, '2017-04-01', '2017-08-01', 'wip');
insert into order_table (order_id, actual_deliver_date, expect_deliver_date, order_status) values (1000000003, '2017-06-01', '2017-08-01', 'wip');
insert into order_table (order_id, actual_deliver_date, expect_deliver_date, order_status) values (1000000004, '2017-08-01', '2017-08-01', 'new');
insert into order_table (order_id, actual_deliver_date, expect_deliver_date, order_status) values (1000000005, '2018-01-01', '2018-01-01', 'new');
insert into order_table (order_id, actual_deliver_date, expect_deliver_date, order_status) values (1000000006, '2018-01-01', '2018-01-01', 'new');
insert into order_table (order_id, actual_deliver_date, expect_deliver_date, order_status) values (1000000007, '2018-03-01', '2018-01-01', 'new');
insert into order_table (order_id, actual_deliver_date, expect_deliver_date, order_status) values (1000000008, '2018-05-01', '2018-07-01', 'new');
insert into order_table (order_id, actual_deliver_date, expect_deliver_date, order_status) values (1000000009, '2018-07-01', '2018-09-01', 'completed');
insert into order_table (order_id, actual_deliver_date, expect_deliver_date, order_status) values (1000000010, '2018-09-01', '2018-09-01', 'completed');

insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000000, 'prod 1', 'unit 1', 1, 100)
insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000001, 'prod 2', 'unit 2', 1, 100)
insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000002, 'prod 3', 'unit 2', 1, 100)
insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000003, 'prod 4', 'unit 2', 1, 100)
insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000004, 'prod 5', 'unit 2', 1, 100)
insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000005, 'prod 6', 'unit 2', 1, 100)
insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000006, 'prod 7', 'unit 2', 1, 100)
insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000007, 'prod 8', 'unit 2', 1, 100)
insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000008, 'prod 9', 'unit 2', 1, 100)
insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000009, 'prod 10', 'unit 2', 1, 100)
insert into product_table (product_id, product_name, product_unit, speed_quantity, speed_second) values (3000000010, 'prod 11', 'unit 2', 1, 100)

insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000000, 5.02, 'hkg', 'hahah', 'g')
insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000001, 6.02, 'hkg', 'hahah', 'kg')
insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000002, 6.02, 'hkg', 'hahah', 'kg')
insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000003, 6.02, 'hkg', 'hahah', 'kg')
insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000004, 6.02, 'hkg', 'hahah', 'kg')
insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000005, 6.02, 'hkg', 'hahah', 'kg')
insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000006, 6.02, 'hkg', 'hahah', 'kg')
insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000007, 6.02, 'hkg', 'hahah', 'kg')
insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000008, 6.02, 'hkg', 'hahah', 'kg')
insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000009, 6.02, 'hkg', 'hahah', 'kg')
insert into source_table (source_id, price, provider_name, source_name, source_unit) values (5000000010, 6.02, 'hkg', 'hahah', 'kg')

insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000000, '2017-01-01', '2017-01-01', 1000000000, 3000000000, '2017-01-01', 'New', 10000);
insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000001, '2017-01-01', '2017-01-01', 1000000001, 3000000001, '2017-01-01', 'New', 10000);
insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000002, '2017-01-01', '2017-01-01', 1000000002, 3000000002, '2017-01-01', 'New', 10000);
insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000003, '2017-01-01', '2017-01-01', 1000000003, 3000000003, '2017-01-01', 'New', 10000);
insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000004, '2017-01-01', '2017-01-01', 1000000004, 3000000004, '2017-01-01', 'New', 10000);
insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000005, '2017-01-01', '2017-01-01', 1000000005, 3000000005, '2017-01-01', 'New', 10000);
insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000006, '2017-01-01', '2017-01-01', 1000000006, 3000000006, '2017-01-01', 'New', 10000);
insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000007, '2017-01-01', '2017-01-01', 1000000007, 3000000007, '2017-01-01', 'New', 10000);
insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000008, '2017-01-01', '2017-01-01', 1000000008, 3000000008, '2017-01-01', 'New', 10000);
insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000009, '2017-01-01', '2017-01-01', 1000000009, 3000000009, '2017-01-01', 'New', 10000);
insert into work_table (work_id, actual_deliver_date, expect_deliver_date, order_order_id, product_product_id, plan_deliver_date, work_status, quantity) values (2000000010, '2017-01-01', '2017-01-01', 1000000010, 3000000010, '2017-01-01', 'New', 10000);

insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000000, 3000000000, 1, 5000000000)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000001, 3000000000, 2, 5000000001)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000002, 3000000001, 1, 5000000000)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000003, 3000000002, 1, 5000000001)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000004, 3000000003, 1, 5000000003)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000005, 3000000004, 1, 5000000002)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000006, 3000000005, 1, 5000000005)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000007, 3000000006, 1, 5000000006)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000008, 3000000006, 1, 5000000007)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000009, 3000000007, 1, 5000000008)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000010, 3000000007, 1, 5000000009)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000011, 3000000007, 1, 5000000004)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000012, 3000000008, 1, 5000000005)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000013, 3000000009, 1, 5000000009)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000014, 3000000010, 1, 5000000001)
insert into product_source (product_source_id, product_product_id, quantity, source_source_id) values (4000000015, 3000000010, 1, 5000000002)
