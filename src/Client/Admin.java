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
				System.out.println("다시입력해주세요");
			}
		}
	}
	
	public void menu() {
		System.out.println("1. 전체메뉴 보기");
		System.out.println("2. 주문정보 입력하기");
		System.out.println("3. 주문내역 보기");
		System.out.println("4. 구매수량 추가하기");
		System.out.println("5. 주문취소하기");
	}

}
