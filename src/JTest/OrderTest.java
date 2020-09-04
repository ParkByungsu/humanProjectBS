package JTest;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.Order_DAO;
import DTO.Order_DTO;


public class OrderTest {
	Order_DAO odao = null;

	@Before
	public void test() {
		odao = Order_DAO.getInstance();
	}
	
	@Test
	public void TestInsertOrder() {
		Order_DTO odto = new Order_DTO();
		odto.setno(25);
		odto.setShsize(260);
		odto.setShprice(99000);
		odto.setShcnt(6);
		odao.OrderInsert(odto);
	}
	
	@Test
	public void TestOrderSelectAll() {
		ArrayList<Order_DTO> olist = odao.OrderSelectAll();
		for (int i = 0; i < olist.size(); i++) {
			System.out.println("---------------------");
			System.out.println(i + 1 + "번 제품 정보");
			System.out.println(olist.get(i).getno());
			System.out.println(olist.get(i).getShsize());
			System.out.println(olist.get(i).getShprice());
			System.out.println(olist.get(i).getShcnt());
			System.out.println("---------------------");
		}

	}
	@Test
	public void TestOrderDelete() {
		odao.OrderDelete(30);
	}
	
	
}
