### rabbitmq

#### 可靠性

##### 生产者

​	 (原生代码，springboot封装的RabbitTemaplte更简单)

+ 事务模式 

  ```java
  try{
      channel.txSelect();//设置事务模式    
      channel.bisicPublish();//发送消息 
      channel.txCommit();//成功即发送成功会阻塞   
  }cache(Exception e){    
  	channel.txRollback();
  }
  ```

+ 确认模式

  + 设置确认模式  

    ```java
    channel.confirmSelect();//开启确认
    channel.bisicPublish();
    boolean b = channel.waitForconfirms();//确认
    if(b){
    }
    ```

+ 批量确认模式

  + 一次多条

+ 异步确认模式（confirmCallback）

  ```java
  
  ```


##### 服务端(broker)

+ 如果交换机不能正确发送的queue  会被退回到生产者，生产者配置如下监听

  ```java
  //第三个参数设置mandatory设置true会被退回，fasle会被直接丢弃
  channel.bisicPublish("","",true);
  channel.addReturnListener(new ReturnListener(){
      ...
  });
  ```

+ 备胎交换机，无法路由到queue ,会发给备胎  （注：死信队列是队列的备份）

+ 交换机持久化到磁盘   队列持久化  消息本身持久化

##### 消费端

+ 手动ack  需要开启

  + spring中三种模式  none 收到自动应答  munit手动应答 auto:根据异常情况智能应答

  ```java
  channel.Ack(envelop.getDeliveryTag,true);
  //拒绝，再发给broker
  channel.basicReject()
  ```

##### 问题

1. 生产者怎么知道消费者消费了消息呢？

​	对方反馈 ：通过api接口，再回发一条消息, ...

2. 生产者认为消息没有被消费成功？

​	长时间没有收到反馈，重发，衰减发送

3. 消费者如何处理重复消息？

​	业务id幂等性

​	

### 集群

#### 节点类型

+ 磁盘节点 disc 持久化，备份作用
+ 内存节点 ram 与应用交互

#### 集群类型

+ 普通集群 

  + 内容只存在一台节点上  
  + 通过节点转发连接

+ 镜像队列

  + 通过路由连接


​	