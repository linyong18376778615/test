package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.iotek.dao.goodsDao;
import com.iotek.dao.impl.goodsDaoImpl;
import com.iotek.entity.goods;

public class goodsTest {
      goodsDao dao=new goodsDaoImpl();
	//商品的单元测试
      
/* @Test
	public void addTest(){//测试商品添加
		goods goodsInfo=new goods(2, "梨", 1, " 产地：河北、山东、河南、天津", 2, 2, "images/img13.jpg");
		try {
			dao.saveGoods(goodsInfo);
			System.out.println("添加商品成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("添加商品失败");
		}
	}*/
 
/* @Test
	public void delTest(){//测试商品删除
		goods goods=new goods();
		goods.setGoodsId(24);
		
		try {
			dao.delGoods(goods.getGoodsId());
			System.out.println("删除商品成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/
 
 /*@Test
	public void findAll(){//测试查询所有商品
		List<goods>list=new ArrayList<goods>();
		try {
			list=dao.queryAllGoods();
			for(goods list1:list){
				  System.out.println(list1);
			  }
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("查询商品失败");
		}
		 

      }*/
     /* @Test
      public void findGoodsById(){
    	  try{//测试按商品ID查询商品
    		  goods goodsInfo=dao.queryGoodsById(6);
    		  System.out.println(goodsInfo);
    	  }catch(Exception e){
    		  e.printStackTrace();
    		  System.out.println("查询商品失败");
    	  }
      }*/
      
     /* @Test
      public void findGoodsByName(){
    	  try{//测试商品名查询商品（模糊搜索商品）
    		  String a1="猕猴桃";
    		  List<goods> list=dao.queryGoodsByName(a1);
    		  for(int i=0;i<list.size();i++){
			 		goods a=list.get(i);
			 		System.out.print(a);
    		  }
    	  }catch(Exception e){
    		  e.printStackTrace();
    		  System.out.println("查询商品失败");
    	  }
      }
      */
      
     /* @Test
      public void modify(){//测试修改
    	  goods goods=new goods(55,"猕猴桃",4,"66",66,66,"66");
  		try {
  			dao.updateGoods(goods);
  			System.out.println("修改成功");
  			System.out.println(goods);
  		} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			System.out.println("修改失败");
  		}
      }*/
      
      @Test
      public void findGoodsByType(){
    	  try{//按类型查询商品
    		 
    		  List<goods> list=dao.queryGoodsByType(1);
    		  for(int i=0;i<list.size();i++){
			 		goods a=list.get(i);
			 		System.out.print(a);
    		  }
    	  }catch(Exception e){
    		  e.printStackTrace();
    		  System.out.println("查询商品失败");
    	  }
      }
      
      
}
