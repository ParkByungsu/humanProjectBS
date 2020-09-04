package JTest;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.ShoesShop_DAO;
import DTO.ShoesShop_DTO;

public class ShoesShopTest {
	ShoesShop_DAO sdao = null;

	@Before
	public void test() {
		sdao = ShoesShop_DAO.getInstance();
	}

	@Test
	public void TestSelectAll() {
		ArrayList<ShoesShop_DTO> slist = sdao.selectAll();
		for (int i = 0; i < slist.size(); i++) {
			System.out.println("---------------------");
			System.out.println(i + 1 + "번 제품 정보");
			System.out.println(slist.get(i).getNo());
			System.out.println(slist.get(i).getCode());
			System.out.println(slist.get(i).getName());
			System.out.println(slist.get(i).getMaker());
			System.out.println(slist.get(i).getShosesize());
			System.out.println(slist.get(i).getPrice());
			System.out.println(slist.get(i).getCnt());
			System.out.println("---------------------");
		}

	}

	@Test
	public void TestInsertShoes() {
		ShoesShop_DTO sdto = new ShoesShop_DTO();
		sdto.setCode("n1113");
		sdto.setName("코르테즈");
		sdto.setMaker("나이키");
		sdto.setShosesize(260);
		sdto.setPrice(99000);
		sdto.setCnt(7);
		sdao.insertShoes(sdto);

	}

	@Test
	public void TestCntUpdate() {
		sdao.cntUpdate(30, 1);

	}

	@Test
	public void TestSelectOne() {
		ShoesShop_DTO ssd = sdao.selectOne(24);
		System.out.println(ssd.getCode());
		System.out.println(ssd.getName());
		System.out.println(ssd.getMaker());
		System.out.println(ssd.getShosesize());
		System.out.println(ssd.getPrice());
		System.out.println(ssd.getCnt());
	}
	@Test
	public void TestShoesDelete() {
		sdao.ShoesDelete(30);
		
	}

	
	
	
	
	
}
