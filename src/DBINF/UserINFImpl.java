package DBINF;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.Order_DAO;
import DAO.ShoesShop_DAO;
import DTO.Order_DTO;
import DTO.ShoesShop_DTO;

public class UserINFImpl implements UserINF {
	private Order_DAO odao = Order_DAO.getInstance();
	private ShoesShop_DAO sdao = ShoesShop_DAO.getInstance();
	private ArrayList<Order_DTO> olist = null;
	private static UserINFImpl uInfI = new UserINFImpl();

	private UserINFImpl() {
	}

	public static UserINFImpl getinstance() {
		return uInfI;
	}

	Scanner in = new Scanner(System.in);

	@Override
	public ArrayList<ShoesShop_DTO> SelectAll() {
		ArrayList<ShoesShop_DTO> slist = new ArrayList<>();
		for (int i = 0; i < slist.size(); i++) {
			System.out.println("----------------");
			System.out.println(i + 1 + "�� ��ǰ �����Դϴ�");
			System.out.println(slist.get(i).getNo());
			System.out.println(slist.get(i).getCode());
			System.out.println(slist.get(i).getName());
			System.out.println(slist.get(i).getMaker());
			System.out.println(slist.get(i).getShosesize());
			System.out.println(slist.get(i).getPrice());
			System.out.println(slist.get(i).getCnt());
			System.out.println("----------------");
		}
		return sdao.selectAll();
	}

	@Override
	public void OrderInsert() {
		olist = new ArrayList<>();
		Order_DTO otemp = new Order_DTO();
		System.out.println("������ ��ǰ�� ��ȣ�� �Է����ּ���");
		otemp.setno(in.nextInt());
		in.nextLine();
		System.out.println("������ ��ǰ�� ����� �Է����ּ���");
		otemp.setShsize(in.nextInt());
		in.nextLine();
		System.out.println("������ ��ǰ�� ������ �Է����ּ���");
		otemp.setShprice(in.nextInt());
		in.nextLine();
		System.out.println("������ ��ǰ�� ������ �Է����ּ���");
		otemp.setShcnt(in.nextInt());
		in.nextLine();
		System.out.println("���Ű� �Ϸ�Ǿ����ϴ�!");
		odao.OrderInsert(otemp);
		olist.add(otemp);

	}

	@Override
	public ArrayList<Order_DTO> OrderList() {
		for (int i = 0; i <= olist.size(); i++) {
			System.out.println(olist.get(i).getno());
			System.out.println(olist.get(i).getShsize());
			System.out.println(olist.get(i).getShprice());
			System.out.println(olist.get(i).getShcnt());
		}
		return olist;
	}

	@Override
	public void OrderCntUpdate() {
		odao.OrderSelectAll();
		System.out.println();
		ArrayList<Order_DTO> olist = new ArrayList<>();
		System.out.println("�߰��ϰ����ϴ� ��ǰ�� no�� �Է����ּ���");
		int a = in.nextInt();
		in.nextLine();
		for (int i = 0; i < olist.size(); i++) {
			if (olist.get(i).getno() == a) {
				odao.CntUpdate(in.nextInt(), a);
				System.out.println(olist.get(i).getno());
				System.out.println(olist.get(i).getShsize());
				System.out.println(olist.get(i).getShprice());
				System.out.println(olist.get(i).getShcnt());
				break;
			}

		}
	}

	@Override
	public void OrderDelete() {
		ArrayList<Order_DTO> olist = new ArrayList<>();
		System.out.println("�����ϰ��� �ϴ� ��ǰ�� no�� �Է����ּ���");
		int a = in.nextInt();
		in.nextLine();
		for (int i = 0; i < olist.size(); i++) {
			if (olist.get(i).getno() == a) {
				olist.remove(i);
			} else {
				System.out.println("�ش������ �����ϴ�");
			}
			break;
		}
	}
}
