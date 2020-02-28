# Docker安装ZooKeeper 3.4.14

### 1. 搜索镜像

Docker Hub搜索找到tag 3.4.14:
https://hub.docker.com/_/zookeeper?tab=tags


然后命令行查看下可用的镜像，我们第一个官方的：

```
➜  ~ docker search zookeeper
NAME                               DESCRIPTION                                     STARS               OFFICIAL            AUTOMATED
zookeeper                          Apache ZooKeeper is an open-source server wh…   802                 [OK]
jplock/zookeeper                   Builds a docker image for Zookeeper version …   164                                     [OK]
wurstmeister/zookeeper                                                             106                                     [OK]
mesoscloud/zookeeper               ZooKeeper                                       73                                      [OK]
bitnami/zookeeper                  ZooKeeper is a centralized service for distr…   26                                      [OK]
mbabineau/zookeeper-exhibitor                                                      24                                      [OK]
digitalwonderland/zookeeper        Latest Zookeeper - clusterable                  20                                      [OK]
tobilg/zookeeper-webui             Docker image for using `zk-web` as ZooKeeper…   14                                      [OK]
confluent/zookeeper                                                                13                                      [OK]
debezium/zookeeper                 Zookeeper image required when running the De…   10                                      [OK]
thefactory/zookeeper-exhibitor     Exhibitor-managed ZooKeeper with S3 backups …   6                                       [OK]
31z4/zookeeper                     Dockerized Apache Zookeeper.                    6                                       [OK]
engapa/zookeeper                   Zookeeper image optimised for being used int…   2
emccorp/zookeeper                  Zookeeper                                       2
josdotso/zookeeper-exporter        ref: https://github.com/carlpett/zookeeper_e…   1                                       [OK]
paulbrown/zookeeper                Zookeeper on Kubernetes (PetSet)                1                                       [OK]
openshift/zookeeper-346-fedora20   ZooKeeper 3.4.6 with replication support        1
duffqiu/zookeeper-cli                                                              1                                       [OK]
perrykim/zookeeper                 k8s - zookeeper  ( forked k8s contrib )         1                                       [OK]
strimzi/zookeeper                                                                  1
dabealu/zookeeper-exporter         zookeeper exporter for prometheus               0                                       [OK]
midonet/zookeeper                  Dockerfile for a Zookeeper server.              0                                       [OK]
humio/zookeeper-dev                zookeeper build with zulu jvm.                  0
phenompeople/zookeeper             Apache ZooKeeper is an open-source server wh…   0                                       [OK]
avvo/zookeeper                     Apache Zookeeper                                0                                       [OK]
```

### 2. 拉取镜像

```
docker pull zookeeper:3.4.14
```

### 3. 查看下本地镜像，zookeeper已经有了：

```
➜  ~ docker images zookeeper
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
zookeeper           3.4.14              ab94f52d305f        26 hours ago        256MB
```

### 4. 启动容器

```
docker run --name docker-zk-3.4.14 -p 2181:2181 --restart always -d zookeeper:3.4.14
```

### 5. 查看容器进程和日志

```
➜  ~ docker ps | grep zookeeper
10a04798a5b4        zookeeper:3.4.14       "/docker-entrypoint.…"   35 minutes ago      Up 35 minutes       2888/tcp, 0.0.0.0:2181->2181/tcp, 3888/tcp   docker-zk-3.4.14
```

```
➜  ~ docker logs 10a04798a5b4
ZooKeeper JMX enabled by default
Using config: /conf/zoo.cfg
2020-02-28 09:09:38,576 [myid:] - INFO  [main:QuorumPeerConfig@136] - Reading configuration from: /conf/zoo.cfg
2020-02-28 09:09:38,583 [myid:] - INFO  [main:DatadirCleanupManager@78] - autopurge.snapRetainCount set to 3
2020-02-28 09:09:38,583 [myid:] - INFO  [main:DatadirCleanupManager@79] - autopurge.purgeInterval set to 0
2020-02-28 09:09:38,583 [myid:] - INFO  [main:DatadirCleanupManager@101] - Purge task is not scheduled.
2020-02-28 09:09:38,584 [myid:] - WARN  [main:QuorumPeerMain@116] - Either no config or no quorum defined in config, running  in standalone mode
2020-02-28 09:09:38,600 [myid:] - INFO  [main:QuorumPeerConfig@136] - Reading configuration from: /conf/zoo.cfg
2020-02-28 09:09:38,601 [myid:] - INFO  [main:ZooKeeperServerMain@98] - Starting server
2020-02-28 09:09:38,611 [myid:] - INFO  [main:Environment@100] - Server environment:zookeeper.version=3.4.14-4c25d480e66aadd371de8bd2fd8da255ac140bcf, built on 03/06/2019 16:18 GMT
2020-02-28 09:09:38,611 [myid:] - INFO  [main:Environment@100] - Server environment:host.name=10a04798a5b4
2020-02-28 09:09:38,611 [myid:] - INFO  [main:Environment@100] - Server environment:java.version=1.8.0_242
2020-02-28 09:09:38,611 [myid:] - INFO  [main:Environment@100] - Server environment:java.vendor=Oracle Corporation
2020-02-28 09:09:38,611 [myid:] - INFO  [main:Environment@100] - Server environment:java.home=/usr/local/openjdk-8
2020-02-28 09:09:38,612 [myid:] - INFO  [main:Environment@100] - Server environment:java.class.path=/zookeeper-3.4.14/bin/../zookeeper-server/target/classes:/zookeeper-3.4.14/bin/../build/classes:/zookeeper-3.4.14/bin/../zookeeper-server/target/lib/*.jar:/zookeeper-3.4.14/bin/../build/lib/*.jar:/zookeeper-3.4.14/bin/../lib/slf4j-log4j12-1.7.25.jar:/zookeeper-3.4.14/bin/../lib/slf4j-api-1.7.25.jar:/zookeeper-3.4.14/bin/../lib/netty-3.10.6.Final.jar:/zookeeper-3.4.14/bin/../lib/log4j-1.2.17.jar:/zookeeper-3.4.14/bin/../lib/jline-0.9.94.jar:/zookeeper-3.4.14/bin/../lib/audience-annotations-0.5.0.jar:/zookeeper-3.4.14/bin/../zookeeper-3.4.14.jar:/zookeeper-3.4.14/bin/../zookeeper-server/src/main/resources/lib/*.jar:/conf:
2020-02-28 09:09:38,612 [myid:] - INFO  [main:Environment@100] - Server environment:java.library.path=/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib
2020-02-28 09:09:38,613 [myid:] - INFO  [main:Environment@100] - Server environment:java.io.tmpdir=/tmp
2020-02-28 09:09:38,613 [myid:] - INFO  [main:Environment@100] - Server environment:java.compiler=<NA>
2020-02-28 09:09:38,616 [myid:] - INFO  [main:Environment@100] - Server environment:os.name=Linux
2020-02-28 09:09:38,616 [myid:] - INFO  [main:Environment@100] - Server environment:os.arch=amd64
2020-02-28 09:09:38,616 [myid:] - INFO  [main:Environment@100] - Server environment:os.version=4.9.184-linuxkit
2020-02-28 09:09:38,616 [myid:] - INFO  [main:Environment@100] - Server environment:user.name=zookeeper
2020-02-28 09:09:38,616 [myid:] - INFO  [main:Environment@100] - Server environment:user.home=/home/zookeeper
2020-02-28 09:09:38,617 [myid:] - INFO  [main:Environment@100] - Server environment:user.dir=/zookeeper-3.4.14
2020-02-28 09:09:38,631 [myid:] - INFO  [main:ZooKeeperServer@836] - tickTime set to 2000
2020-02-28 09:09:38,632 [myid:] - INFO  [main:ZooKeeperServer@845] - minSessionTimeout set to -1
2020-02-28 09:09:38,632 [myid:] - INFO  [main:ZooKeeperServer@854] - maxSessionTimeout set to -1
2020-02-28 09:09:38,648 [myid:] - INFO  [main:ServerCnxnFactory@117] - Using org.apache.zookeeper.server.NIOServerCnxnFactory as server connection factory
2020-02-28 09:09:38,656 [myid:] - INFO  [main:NIOServerCnxnFactory@89] - binding to port 0.0.0.0/0.0.0.0:2181
2020-02-28 09:11:49,275 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:NIOServerCnxnFactory@222] - Accepted socket connection from /172.17.0.1:59028
```

### 5. 客户端连接

从`https://archive.apache.org/dist/zookeeper/zookeeper-3.4.14/zookeeper-3.4.14.tar.gz` 下载3.4.14版本包，解压到`/usr/local/zookeeper-3.4.14
`

把`127.0.0.1:8080`写到`/svc`目录：


```                                                                                                                                           ➜ zookeeper-3.4.14 pwd
/usr/local/zookeeper-3.4.14
➜  zookeeper-3.4.14 ./bin/zkCli.sh -server localhost:2181
Connecting to localhost:2181
2020-02-28 17:47:42,284 [myid:] - INFO  [main:Environment@100] - Client environment:zookeeper.version=3.4.14-4c25d480e66aadd371de8bd2fd8da255ac140bcf, built on 03/06/2019 16:18 GMT
2020-02-28 17:47:42,289 [myid:] - INFO  [main:Environment@100] - Client environment:host.name=192.168.1.4
2020-02-28 17:47:42,289 [myid:] - INFO  [main:Environment@100] - Client environment:java.version=1.8.0_151
2020-02-28 17:47:42,292 [myid:] - INFO  [main:Environment@100] - Client environment:java.vendor=Oracle Corporation
2020-02-28 17:47:42,292 [myid:] - INFO  [main:Environment@100] - Client environment:java.home=/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/jre
2020-02-28 17:47:42,292 [myid:] - INFO  [main:Environment@100] - Client environment:java.class.path=/usr/local/zookeeper-3.4.14/bin/../zookeeper-server/target/classes:/usr/local/zookeeper-3.4.14/bin/../build/classes:/usr/local/zookeeper-3.4.14/bin/../zookeeper-server/target/lib/*.jar:/usr/local/zookeeper-3.4.14/bin/../build/lib/*.jar:/usr/local/zookeeper-3.4.14/bin/../lib/slf4j-log4j12-1.7.25.jar:/usr/local/zookeeper-3.4.14/bin/../lib/slf4j-api-1.7.25.jar:/usr/local/zookeeper-3.4.14/bin/../lib/netty-3.10.6.Final.jar:/usr/local/zookeeper-3.4.14/bin/../lib/log4j-1.2.17.jar:/usr/local/zookeeper-3.4.14/bin/../lib/jline-0.9.94.jar:/usr/local/zookeeper-3.4.14/bin/../lib/audience-annotations-0.5.0.jar:/usr/local/zookeeper-3.4.14/bin/../zookeeper-3.4.14.jar:/usr/local/zookeeper-3.4.14/bin/../zookeeper-server/src/main/resources/lib/*.jar:/usr/local/zookeeper-3.4.14/bin/../conf:
2020-02-28 17:47:42,292 [myid:] - INFO  [main:Environment@100] - Client environment:java.library.path=/Users/dashwang/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.
2020-02-28 17:47:42,292 [myid:] - INFO  [main:Environment@100] - Client environment:java.io.tmpdir=/var/folders/97/whr10r1x4yqfyvnkbgdxsj_c0000gp/T/
2020-02-28 17:47:42,292 [myid:] - INFO  [main:Environment@100] - Client environment:java.compiler=<NA>
2020-02-28 17:47:42,292 [myid:] - INFO  [main:Environment@100] - Client environment:os.name=Mac OS X
2020-02-28 17:47:42,293 [myid:] - INFO  [main:Environment@100] - Client environment:os.arch=x86_64
2020-02-28 17:47:42,293 [myid:] - INFO  [main:Environment@100] - Client environment:os.version=10.14.2
2020-02-28 17:47:42,293 [myid:] - INFO  [main:Environment@100] - Client environment:user.name=dashwang
2020-02-28 17:47:42,293 [myid:] - INFO  [main:Environment@100] - Client environment:user.home=/Users/dashwang
2020-02-28 17:47:42,293 [myid:] - INFO  [main:Environment@100] - Client environment:user.dir=/usr/local/zookeeper-3.4.14
2020-02-28 17:47:42,294 [myid:] - INFO  [main:ZooKeeper@442] - Initiating client connection, connectString=localhost:2181 sessionTimeout=30000 watcher=org.apache.zookeeper.ZooKeeperMain$MyWatcher@41906a77
Welcome to ZooKeeper!
2020-02-28 17:47:42,327 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@1025] - Opening socket connection to server localhost/0:0:0:0:0:0:0:1:2181. Will not attempt to authenticate using SASL (unknown error)
JLine support is enabled
2020-02-28 17:47:42,392 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@879] - Socket connection established to localhost/0:0:0:0:0:0:0:1:2181, initiating session
2020-02-28 17:47:42,404 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@1299] - Session establishment complete on server localhost/0:0:0:0:0:0:0:1:2181, sessionid = 0x1001174427c0005, negotiated timeout = 30000

WATCHER::

WatchedEvent state:SyncConnected type:None path:null
[zk: localhost:2181(CONNECTED) 0] ls /
[registry, zookeeper]
[zk: localhost:2181(CONNECTED) 1] create svc 127.0.0.1:8080
Command failed: java.lang.IllegalArgumentException: Path must start with / character
[zk: localhost:2181(CONNECTED) 2] create /svc 127.0.0.1:8080
Created /svc
[zk: localhost:2181(CONNECTED) 3] ls2 /svc
[]
cZxid = 0xf
ctime = Fri Feb 28 17:48:11 CST 2020
mZxid = 0xf
mtime = Fri Feb 28 17:48:11 CST 2020
pZxid = 0xf
cversion = 0
dataVersion = 0
aclVersion = 0
ephemeralOwner = 0x0
dataLength = 14
numChildren = 0
[zk: localhost:2181(CONNECTED) 4] help
ZooKeeper -server host:port cmd args
	stat path [watch]
	set path data [version]
	ls path [watch]
	delquota [-n|-b] path
	ls2 path [watch]
	setAcl path acl
	setquota -n|-b val path
	history
	redo cmdno
	printwatches on|off
	delete path [version]
	sync path
	listquota path
	rmr path
	get path [watch]
	create [-s] [-e] path data acl
	addauth scheme auth
	quit
	getAcl path
	close
	connect host:port
[zk: localhost:2181(CONNECTED) 5] get /svc
127.0.0.1:8080
cZxid = 0xf
ctime = Fri Feb 28 17:48:11 CST 2020
mZxid = 0xf
mtime = Fri Feb 28 17:48:11 CST 2020
pZxid = 0xf
cversion = 0
dataVersion = 0
aclVersion = 0
ephemeralOwner = 0x0
dataLength = 14
numChildren = 0
[zk: localhost:2181(CONNECTED) 6]
```
