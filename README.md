# simple-factory
简单工厂处理订单流程, 配合java-backend project使用

* 配合java-backend project使用

## 步骤
  1. 执行resources/sql/index.sql文件, 准备数据库、表以及数据
  2. 运行项目
  3. 因为遵循restful api风格, 所以准备好postman或者其它软件用put的方式请求  
     * 非法操作: `localhost:8085/v1/orders/update-status/1?status=FINISHED`  
     * 正常操作: `localhost:8085/v1/orders/update-status/1?status=REFUSE`
     
## 不足点
  1. 订单表设计不合理, 主要目的是为了mock整个流程, 实际项目的订单表肯定没那么简单.
  2. 处理订单状态的处理类目前只写了拒绝接单和生成订单的操作(该操作是生成订单时才会  
     触发, 因为该case中无生成订单的api, 所以该处理器不会被调用到), 其他状态的操作  
     类可以按照RefusedOperate.java类格式写.
     
## 总结
  * 该case主要是采用简单工厂模式构建订单状态的对应处理类, 以及利用java多态特性解决了  
    代码中多`if else`的情况, 工厂类中采用`switch case`的语法进行构建对象, 所以对于  
    `if else`多而感到头疼的同胞有一丁点好处.   
  * 利用该设计的初衷是对于订单的操作降低耦合性, 所有状态的处理都在对应的类中编码, 
    比较好理解. 这样的设计与策略者模式有点相似, 但注意**这不是策略者模式**. 只是  
    利用了java多态特性而已.
    
```
  I'm a slow walker, but i never walk backwards.
```
