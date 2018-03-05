package com.testZK;
import java.util.Arrays;  
import java.util.List;  
import org.apache.zookeeper.CreateMode;  
import org.apache.zookeeper.KeeperException;  
import org.apache.zookeeper.ZooDefs.Ids;  
  
public class ZooKeeperOperator extends AbstractZooKeeper {  
    /** 
     * @param path eg:  /parent/child1
     * @param data 
     * @throws InterruptedException  
     * @throws KeeperException  
     */  
    public void create(String path,byte[] data) throws KeeperException, InterruptedException{  
        this.zooKeeper.create(path, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT/*�˴�������Ϊ�־�̬�Ľڵ�,��Ϊ˲̬*/);  
    }  
      
      
    /** 
     * @param path
     * @throws KeeperException 
     * @throws InterruptedException 
     */  
    public void getChild(String path) throws KeeperException, InterruptedException{  
        try {  
            List<String> children = this.zooKeeper.getChildren(path, false);  
            if (children.isEmpty()) {  
                System.out.printf("子目录为空：", path);
                return;  
            }else{  
                System.out.printf("子目录不为空：", path);
                for(String child: children){  
                    System.out.println(child);  
                }  
            }  
        } catch (KeeperException.NoNodeException e) {  
            System.out.printf("父节点不存在：", path);
            throw e;  
        }  
    }  
  
    public byte[] getData(String path) throws KeeperException, InterruptedException {  
        return  this.zooKeeper.getData(path, false,null);  
    }  
    
    
    public static void main(String[] args) {  
        try {  
            ZooKeeperOperator zkoperator = new ZooKeeperOperator();
            zkoperator.connect("192.168.1.201");  
            byte[] data = new byte[]{'d','a','t','a'};  
              
            zkoperator.create("/root",null);  
            System.out.println(Arrays.toString(zkoperator.getData("/root")));  
              
            zkoperator.create("/root/child1",data);  
            System.out.println(Arrays.toString(zkoperator.getData("/root/child1")));  
              
            zkoperator.create("/root/child2",data);  
            System.out.println(Arrays.toString(zkoperator.getData("/root/child2")));  
              
            System.out.println("获取子目录");
            zkoperator.getChild("/root");  
              
            zkoperator.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    } 
}  