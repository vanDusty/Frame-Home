# Spring-Redis
## 一、阿里云服务器下Redis安装及配置

### 1.下载Redis

1. 去Redis官网下载最新的Linux包(我下载的是4.0.11)，Redis官方没有Windows版的下载。
[https://redis.io/](https://redis.io/)
1. 下载后把包上传到Linux服务器。

### 2.安装Redis

#### 1、解压Redis包

` tar -zxvf redis-4.0.2.tar.gz `

#### 2、切换到Redis解压目录

`cd redis-4.0.11`

#### 3、编译Redis

`make`

> 如报错按以下错误解决(我的这里没报错)
1.错误1：
``` make: cc：命令未找到
    make: *** [adlist.o] 错误 127
```
解决问题命令：
`yum install gcc`

2.错误2：
```
collect2: ld returned 1 exit status
make[1]: *** [redis-server] Error 1
make[1]: Leaving directory `/usr/local/redis/src'
make: *** [all] Error 2
```
解决问题的命令：
` vi src/.make-settings，修改OPT=-O2 -march=x86-64 `
### 4、编译测试

`make test`
报错（我这里也报错了）:
```
make[1]: Entering directory /home/test/redis-4.0.2/src' CC Makefile.dep make[1]: Leaving directory/home/test/redis-4.0.2/src'
make[1]: Entering directory /home/test/redis-4.0.2/src' You need tcl 8.5 or newer in order to run the Redis test make[1]: *** [test] Error 1 make[1]: Leaving directory/home/test/redis-4.0.2/src'
```
解决问题命令：
```$xslt
    wget http://downloads.sourceforge.net/tcl/tcl8.6.7-src.tar.gz
    tar -zxvf tcl8.6.7-src.tar.gz
    cd tcl8.6.7/unix/
    ./configure
    make
    make install
```
> 解决后，返回到redis根目录，再次运行`make test`，运行过后，出现下述代码说明准备就绪：
```$xslt
    \o/ All tests passed without errors!
```

### 3.启动Redis
启动redis src目录下的redis-server命令来启动Redis服务,在redis根目录下执行
```$xslt
    cd src
    ./redis-server ../redis.conf
```
启动成功画面：
```$xslt
    [root@Van src]# ./redis-server ../redis.conf
    16900:C 03 Sep 15:18:09.516 # oO0OoO0OoO0Oo Redis is starting oO0OoO0OoO0Oo
    16900:C 03 Sep 15:18:09.516 # Redis version=4.0.11, bits=64, commit=00000000, modified=0, pid=16900, just started
    16900:C 03 Sep 15:18:09.516 # Configuration loaded
                    _._                                                  
               _.-``__ ''-._                                             
          _.-``    `.  `_.  ''-._           Redis 4.0.11 (00000000/0) 64 bit
      .-`` .-```.  ```\/    _.,_ ''-._                                   
     (    '      ,       .-`  | `,    )     Running in standalone mode
     |`-._`-...-` __...-.``-._|'` _.-'|     Port: 6379
     |    `-._   `._    /     _.-'    |     PID: 16900
      `-._    `-._  `-./  _.-'    _.-'                                   
     |`-._`-._    `-.__.-'    _.-'_.-'|                                  
     |    `-._`-._        _.-'_.-'    |           http://redis.io        
      `-._    `-._`-.__.-'_.-'    _.-'                                   
     |`-._`-._    `-.__.-'    _.-'_.-'|                                  
     |    `-._`-._        _.-'_.-'    |                                  
      `-._    `-._`-.__.-'_.-'    _.-'                                   
          `-._    `-.__.-'    _.-'                                       
              `-._        _.-'                                           
                  `-.__.-'                                               
    
    16900:M 03 Sep 15:18:09.518 # WARNING: The TCP backlog setting of 511 cannot be enforced because /proc/sys/net/core/somaxconn is set to the lower value of 128.
    16900:M 03 Sep 15:18:09.518 # Server initialized
    16900:M 03 Sep 15:18:09.518 # WARNING overcommit_memory is set to 0! Background save may fail under low memory condition. To fix this issue add 'vm.overcommit_memory = 1' to /etc/sysctl.conf and then reboot or run the command 'sysctl vm.overcommit_memory=1' for this to take effect.
    16900:M 03 Sep 15:18:09.518 # WARNING you have Transparent Huge Pages (THP) support enabled in your kernel. This will create latency and memory usage issues with Redis. To fix this issue run the command 'echo never > /sys/kernel/mm/transparent_hugepage/enabled' as root, and add it to your /etc/rc.local in order to retain the setting after a reboot. Redis must be restarted after THP is disabled.
    16900:M 03 Sep 15:18:09.518 * DB loaded from disk: 0.000 seconds
    16900:M 03 Sep 15:18:09.518 * Ready to accept connections

```

### 4.连接Redis
启动`redis/src`目录下的`redis-cli`命令来连接到Redis服务。

```$xslt
    ./redis-cli
```

连接成功：
```
127.0.0.1:6379>
```