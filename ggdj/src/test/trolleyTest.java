package test;

import java.util.List;

import org.junit.Test;

import com.iotek.dao.tQuantityDao;
import com.iotek.dao.trolleyDao;
import com.iotek.dao.impl.tQuantityDaoImpl;
import com.iotek.dao.impl.trolleyDaoImpl;
import com.iotek.entity.goods;
import com.iotek.entity.order;
import com.iotek.entity.tQuantity;
import com.iotek.entity.trolley;

public class trolleyTest {
	trolleyDao dao=new trolleyDaoImpl();
	tQuantityDao dao1=new tQuantityDaoImpl();
	  @Test
	public void add(){//测试购物车的添加
		    trolley trolley=new trolley();    
			trolley.setUserName("Lily");//为用户输入数据（一用户只有一个购物车）
			
 		try {
 			dao.saveTrolley(trolley);//添加购物车
 			System.out.println("添加购物车成功");
				  } catch (Exception e) {
 			
 			e.printStackTrace();
 			System.out.println("添加购物车失败");
 		}
    }
     
	  @Test
	  public void add2(){//往购物车里添加商品
		  trolley trolley1=new trolley();  
		    trolley1.settrolleyId(1);
		    tQuantity oo=new tQuantity(13,1,1);//输入数据
		    try{
		    	dao1.saveTQuantity(oo);
	 			System.out.println("商品添加购物车成功");
		    }catch (Exception e) {
	 			
	 			e.printStackTrace();
	 			System.out.println("商品添加失败");}
		   
	  }
       
      /* @Test
       public void delTest(){
    	   try{
    	       dao1.delTQuantity(5,1);
    	       System.out.println("删除成功");
    	   }catch(Exception e){
    		   e.printStackTrace();
    		   System.out.println("删除失败");
    	   }
    	   
       }*/
       
      /* @Test
       public void modTest(){
    	   tQuantity goods=new tQuantity(2,5,3,1);
    	
     		try {
     			dao1.updateTQuantity(goods);
     			System.out.println("修改成功");
     			System.out.println(goods);
     		} catch (Exception e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     			System.out.println("修改失败");
     		}
    	   }*/
       
       @Test
       public void select(){
    	   try{
    		   List<goods> list=dao1.queryUserCart(1);//根据id号查询购物车下的商品
    		   System.out.println(list.size());
    		   for(int i=0;i<list.size();i++){
			 		goods a=list.get(i);
			 		System.out.print(a);
   		  }
    	   }catch (Exception e){
    		   e.printStackTrace();
    	   }
       }
       
}
