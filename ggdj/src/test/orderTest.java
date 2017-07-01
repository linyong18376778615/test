package test;

import java.util.List;

import org.junit.Test;

import com.iotek.dao.oQuantityDao;
import com.iotek.dao.orderDao;
import com.iotek.dao.impl.oQuantityDaoImpl;
import com.iotek.dao.impl.orderDaoImpl;
import com.iotek.entity.oQuantity;
import com.iotek.entity.order;


public class orderTest {
       orderDao dao=new orderDaoImpl();
       oQuantityDao dao1=new oQuantityDaoImpl();

    /* @Test
 	public void Test1(){//此处测试一个订单的生成及查询（包括订单表与订单数量表的添加测试，查询测试）
 		order order=new order("2017061423",10,"测试地址",30);//输入数据测试在订单表生成订单
 		oQuantity oo=new oQuantity(13,3,"2017061423");//商品数量表中的商品
 		try {
 			dao.saveOrder(order);
 			dao1.saveOQuantity(oo);
 			System.out.println("生成订单成功");
 			
 			System.out.println("测试订单表里的订单");
 			order order1=dao.queryOrder("2017061423");//测试订单表的查询功能
 			
 			System.out.println("测试查询该的订单号下的商品");
 			List<oQuantity> o1=dao1.queryUserOrderInfo("2017061423");//测试查询订单数量表
 			
 			for(oQuantity list1:o1){
				  System.out.println(list1);
				  }
 			
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }
}*/
       
       /*@Test
       public void delTest(){
    	   try{
    	       dao.delOrder("2017061423");
    	       dao1.delOQuantity("2017061423");
    	       System.out.println("删除成功");
    	   }catch(Exception e){
    		   e.printStackTrace();
    		   System.out.println("删除失败");
    	   }
    	   }
       }*/
       
       @Test
       public void modTest(){
    	   order goods=new order("20170608_085621",10,"66",66);
    	
     		try {
     			dao.updateOrder(goods);
     			System.out.println("修改成功");
     			System.out.println(goods);
     		} catch (Exception e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     			System.out.println("修改失败");
     		}
    	   }
       
       
       }
       
