CREATE DATABASE order_flow;

CREATE TABLE order_flow_operation(
  order_flow_operation_id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  order_status TINYINT(1) NOT NULL COMMENT "对应order status enum",
  payment_type TINYINT(1) NOT NULL COMMENT "订单交易方式, 每种交易方式对应一个订单流水操作",
  next_executable_operation VARCHAR(100) COMMENT "存储order operation的value, 用,隔开",
  next_changeable_status VARCHAR(100) COMMENT "存储order status enum的value, 用,隔开"
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO order_flow_operation(name, order_status, payment_type, next_executable_operation, next_changeable_status) VALUES
("待接单", 0, 0, "0,1,2,3", "1,2,4,3"),
("拒绝接单", 1, 0, null, null),
("买家取消接单", 2, 0, null, null),
("待支付", 3, 0, "4,5,6", "5,2,4"),
("已关闭", 4, 0, null, null),
("待发货", 5, 0, "7,8", "6,4"),
("待收货", 6, 0, "9, 10", "10,10"),
("完成", 10, 0, null, null),
("待接单", 0, 1, "0,1,2,3", "1,2,4,5"),
("拒绝接单", 1, 1, null, null),
("买家取消接单", 2, 1, null, null),
("已关闭", 4, 1, null, null),
("待发货", 5, 1, "7", "7"),
("待对账还款", 7, 1, "11", "10"),
("完成", 10, 1, null, null);