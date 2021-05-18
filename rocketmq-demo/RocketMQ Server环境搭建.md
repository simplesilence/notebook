### RocketMQ Server环境搭建

~~~
1、官网下载binary二进制包，并解压

2、进入解压后的bin目录

3、启动nameserver：>.\mqnamesrv.cmd

4、启动broker：> .\bin\mqbroker.cmd -n localhost:9876 autoCreateTopicEnable=true

5、（可选）下载console控制台，在rocketmq的externals github扩展里面找到rocketmq-console项目进行下载，打包运行（修改springboot的配置参数mq地址）

6、根据https://rocketmq.apache.org/docs/simple-example/例子学习
~~~

