package DBINF;

import java.util.ArrayList;

import DTO.Order_DTO;
import DTO.ShoesShop_DTO;

public interface UserINF {
	//Order----------------------
		//1. ��ǰ���
		public ArrayList<ShoesShop_DTO> SelectAll();
		//2. ���Ÿ�� �߰�
		public void OrderInsert();
		//3. ���� ���
		public ArrayList<Order_DTO> OrderList();
		//4. ���ż��� �߰�
		public void OrderCntUpdate();
		//5. ���� ���
		public void OrderDelete();

}
