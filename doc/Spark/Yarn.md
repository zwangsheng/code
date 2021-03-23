# Yarn

## What is yarn

apache yarn 是 apache hadoop下的子项目，主要是为了分离hadoop2.0资源管理和计算组件而引入的。

Hadoop2.0的yarn为hadoop提供了更多框架的选择，你不用局限在hadoop自带的MapReduce框架，可以使用spark框架作为代替。

## Architecture

![architecture](../images/spark/yarn/Architecture.png)
> The fundamental idea of YARN is to split up the functionalities of resource management and job scheduling/monitoring 
> into separate daemons. The idea is to have a global ResourceManager (RM) and per-application ApplicationMaster (AM). 
> An application is either a single job, or a DAG of jobs.
> https://hadoop.apache.org/docs/current/hadoop-yarn/hadoop-yarn-site/YARN.html

上面是来自Apache.yarn官网的描述，讲的是yarn的基本思想是将资源管理和作业调度/监听的功能进行拆分成单独的守护进程。

按照这个想法，拆出了一个全局的ResourceManager（RM）和每个应用拥有的ApplicationManager（AM）。

ResourceManager和NodeManager构成了计算框架。
### ResourceManager
ResourceManager是所有Application之间仲裁资源的最终权限者，为每个Application分配资源（CPU，内存，磁盘，网络）。

ResourceManager有两个重要的组件：Scheduler和ApplicationsManager。

Yarn通过[ReservationSystem](https://hadoop.apache.org/docs/current/hadoop-yarn/hadoop-yarn-site/ReservationSystem.html)
支持resource reservation的思想。
#### Scheduler
Scheduler负责按照容量，队列给正在运行的Application分配资源。

同时，他也不再对应用程序的状态进行跟踪和监听。当然，他也不在负责重启失败的服务。

Scheduler基于资源容器抽象的概念（Container），根据Application的资源需求执行调度的功能。

Scheduler具有可插拔的负责队列和应用程序的的分配策略。
#### ApplicationsManager
ApplicationsManager负责接受作业的提交，协商用于执行特定的ApplicationMaster的First Container，并且在发生故障是重启ApplicationMaster。

每个应用的ApplicationMaster负责和Scheduler协商Container，并且跟踪其状态和监视进程。

### NodeManager
NodeManager是每台机器的管理者，负责监视容器的资源使用情况，并且报告给ResourceManager。

### ApplicationManager
Application是一个特殊的框架资源库，负责与ResourceManager进行资源的协商，和NodeManager一起监视和执行任务。

### Container
资源容器的一个概念，包含CPU，内存，磁盘，网络