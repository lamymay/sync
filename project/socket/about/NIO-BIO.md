

区别
BIO是面向流的
阻塞


NIO是面向缓冲区的利用管道完成传输
非阻塞


通道：传输数据

缓存区：存数据




选择websocket，http/2
96  skoll 
2019.02.15 10:16 字数 108 阅读 168评论 0喜欢 0
1 .需要客户端和服务器之间的真正低延迟，接近实时的连接，就使用websocket，这可能需要考虑如何构建服务端应用程序，以及将焦点转移到队列事件等技术上
2 .实时显示市场消息，市场数据，聊天应用程序等，依靠HTTP2,sse将为你提供搞笑的双向通信渠道
https://segmentfault.com/a/1190000014693891

https://blog.csdn.net/moshowgame/article/details/83415545
https://github.com/patience00/SpringBoot-WebSocket-kafka
