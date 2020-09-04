package DBINF;

import java.util.ArrayList;

import DTO.Order_DTO;
import DTO.ShoesShop_DTO;

public interface UserINF {
	//Order----------------------
		//1. 상품목록
		public ArrayList<ShoesShop_DTO> SelectAll();
		//2. 구매목록 추가
		public void OrderInsert();
		//3. 구매 목록
		public ArrayList<Order_DTO> OrderList();
		//4. 구매수량 추가
		public void OrderCntUpdate();
		//5. 구매 취소
		public void OrderDelete();

}
