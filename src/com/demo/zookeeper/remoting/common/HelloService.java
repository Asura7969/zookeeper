package com.demo.zookeeper.remoting.common;
 
import java.rmi.Remote;
import java.rmi.RemoteException;
 
/**
 * @author gongwenzhou
 */
public interface HelloService extends Remote {
 
    String sayHello(String name) throws RemoteException;
}