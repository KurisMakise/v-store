进度：前台基础功能开发完成,可以跑一遍流程，待整合分布式框架

部署：
导入project-doc下sql脚本
修改store-os-web模块下资源文件夹resourses/application.yaml中spring:datasource数据源，运行store-os-web模块下store.Application

基于springboot maven开发<br>
安全框架：Apache Shiro(Ehcache缓存)<br>
持久层框架：MyBatis + Mybatis-plus <br>
布局框架：SiteMesh <br>
接口测试框架：Swagger2 <br>
其他：kaptcha验证码，velocity发送邮件<br><br>
待添加<br>
分布式服务框架：Dubbo+ZooKeeper同步调用（待整合）<br>
RocketMQ解耦异步调用（待整合）<br>
搜索引擎:Elasticsearch（待整合）<br>
缓存框架:redis（待整合）<br>

更新日志：<br>
2019-4-14 新增redis缓存，采用aop注解形式<br>


数据库er图
![数据库er图](https://github.com/RyougiSHikii/v-store/blob/master/project-doc/picture/%E6%95%B0%E6%8D%AE%E5%BA%93ER%E6%80%BB%E5%9B%BE.jpg)



