package com.demo.zookeeper.remoting.server;
 
import com.demo.zookeeper.remoting.common.HelloService;
 
public class Server {
 
    public static void main(String[] args) throws Exception {
//        if (args.length != 2) {
//            System.err.println("please using command: java Server <rmi_host> <rmi_port>");
//            System.exit(-1);
//        }
// 
//        String host = args[0];
//        int port = Integer.parseInt(args[1]);

    	
//    	当前rmi服务器的ip 和端口
        String host = "192.168.67.1";
        int port = Integer.parseInt("11231");
        ServiceProvider provider = new ServiceProvider();
 
        HelloService helloService = new HelloServiceImpl();
        provider.publish(helloService, host, port);
 
        Thread.sleep(Long.MAX_VALUE);
    }
}