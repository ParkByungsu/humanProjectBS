package Client;

import java.util.Scanner;

import DBINF.UserINFImpl;

public class Admin {
	private UserINFImpl uInfI = UserINFImpl.getinstance();
	Scanner in = new Scanner(System.in);
	
	public Admin() {
		Home();
	}
	public void Home() {
		while (true) {
			menu();
			int key = in.nextInt();
			in.nextLine();
			switch (key) {
			case 1: uInfI.SelectAll();break;
			case 2: uInfI.OrderInsert();break;
			case 3: uInfI.OrderList();break;
			case 4: uInfI.OrderCntUpdate();break;
			case 5: uInfI.OrderDelete();break;

			default:
				System.out.println("�ٽ��Է����ּ���");
			}
		}
	}
	
	public void menu() {
		System.out.println("1. ��ü�޴� ����");
		System.out.println("2. �ֹ����� �Է��ϱ�");
		System.out.println("3. �ֹ����� ����");
		System.out.println("4. ���ż��� �߰��ϱ�");
		System.out.println("5. �ֹ�����ϱ�");
	}

}
