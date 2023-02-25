cloud-api-commons 一些公共的pojo和一些公共方法的模块，用于生成gav坐标供其他组件使用

eureka : 服务端(集群) eureka-server7001、eureka-server7002
            客户端 服务提供者(集群) provider-payment8001、provider-payment8002
                    服务消费者    consumer-order80 + ribbon的负载均衡练习

zookeeper: 服务端 :部署在阿里云linux中 124.71.238.184:2081
            客户端 服务提供者（单机） provider-payment8004
                    服务消费者    consumerzk-order80

zookeeper: 服务端 :部署在windows  localhost:8500
            客户端 服务提供者（单机） providerconsul-payment8006
                    服务消费者    consumerconsul-order80

openFeign: 服务端集群和eureka集群还是用 第一套
            客户端 cloud-consumerFeign-order80

Hystrix: eureka集群 + hystrix-payment8001