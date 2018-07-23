#SpringCloud入门#
##本Demo主要介绍Eureka、Ribbon、Hystrix、Zuul##

###服务提供者 file/user/log
    可配置服务提供者集群

###服务消费者 common
    服务统一对外消费,已配置Ribbon负载均衡
    可分别搭建消费者

###服务注册中心 eureka
    可配置服务注册中心集群

###服务监控熔断 dashboard/hystric
    熔断须在服务提供者配置

###网关 zuul
    本DEMO只设置了token验证过滤机制

