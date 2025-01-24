import java.util.ArrayList;
import java.util.Scanner;

public class Control {
	
//	static ArrayList<String> alName = new ArrayList<String>(); // 모든 메소드에서 사용해야 된다면, 모든 메소드를 포함하는 클래스 바로 아래에 작성
//	static ArrayList<Integer> alPrice = new ArrayList<Integer>(); // static이 붙은 메소드 안에서는 static을 앞에 붙여준 변수만 쓸 수 있음
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		ArrayList<String> alName = new ArrayList<String>(); // 메뉴 목록
		ArrayList<Integer> alPrice = new ArrayList<Integer>(); //메뉴 가격
		
		ArrayList<String> alMenu = new ArrayList<String>(); // 주문 메뉴
		ArrayList<Integer> alCount = new ArrayList<Integer>(); // 주문 수량
		ArrayList<Integer> alSum = new ArrayList<Integer>(); // 
		ArrayList<String> alMobile = new ArrayList<String>();
		
		while (true) {
			System.out.println("================\t<시스템관리>\t================");
			System.out.print("작업 선택 [m:메뉴관리, o:주문관리, s:매출관리, x:종료] : ");
			String insert=s.nextLine();
			
//			if (insert.equals("x") || insert.equals("X")) {
//				break;
//			} else if (insert.equals("m") || insert.equals("M")) {
//				
//			} else if (insert.equals("o") || insert.equals("O")) {
//				
//			} else if (insert.equals("s") || insert.equals("S")) {
//				
//			} else {
//				
//			}
			
			if (insert.equals("x") || insert.equals("X")) {
				break;
			}
			switch (insert) {
			case "m","M":
				doMenu(alName, alPrice); // 'doMenu를 콜(call)한다'라고 표현 => doMenu를 호출 (호출부)
			break;
			case "o","O":
				doOrder(alName, alPrice, alMenu, alCount, alSum, alMobile);
				break;
			case "s","S":
				doSales(alName, alPrice, alMenu, alCount, alSum, alMobile);
				break;
			default:
				invalidInput();
				break;
			}
			
			
		}
		System.out.println("\nProgram END");
		s.close();
		
	}
	
	
	public static boolean isNumber(String str) {
		// 정규식을 사용하여 숫자와 소수점만 있는지 확인
		return str.matches("-?\\d*(\\.\\d+)?"); // 정규표현식
	}
	
	
	// 잘못된 입력 시 출력 에러 메소드
	public static void invalidInput() {
		System.out.println("> 잘못된 입력입니다.\n");
	}
	
	
	// 메뉴관리 메소드 : 1.메뉴추가 2.메뉴수정 3.메뉴삭제 4.메뉴보기 5.관리종료
	public static void doMenu(ArrayList<String> alName, ArrayList<Integer> alPrice) { // 함수(function) 또는 메소드(method)라고 부름 (선언부)
		Scanner s = new Scanner(System.in);
		
		System.out.println("================\t <메뉴관리> \t================");
		while (true) {
			System.out.print("작업 선택 [c:메뉴추가, u:메뉴수정, d:메뉴삭제, r:메뉴보기, x:종료] : "); // c:Create, r:Read, u:Update, d:Delete => ***CRUD
			String mch=s.nextLine();
			
			if (mch.equals("x") || mch.equals("X")) { // 종료
				break;
			}
			switch (mch) {
			case "c","C":
				System.out.println(">>> 메뉴추가");
				addMenu(alName, alPrice);
				break;
			case "u","U":
				System.out.println(">>> 메뉴수정");
				updateMenu(alName, alPrice);
				break;
			case "d","D":
				System.out.println(">>> 메뉴삭제");
				deleteMenu(alName, alPrice);
				break;
			case "r","R":
				System.out.println(">>> 메뉴보기");
				showMenu(alName, alPrice);
				break;
			default:
				invalidInput();
				break;
			}
		}
	}
	
	// 메뉴관리-메뉴추가 메소드
	// while문 안에서 alName, alPrice에 메뉴명, 가격을 추가 / 메뉴명이 빈문자열이거나 가격이 0원이면 while문 종료
	public static void addMenu(ArrayList<String> alName, ArrayList<Integer> alPrice) {
		Scanner si = new Scanner(System.in); // 정수형
		Scanner ss = new Scanner(System.in); // 문자열

		while (true) {
			System.out.print("메뉴명 입력: ");
			String name=ss.nextLine();
			System.out.print("가격 입력: ");
			int price=si.nextInt();

			if (name.equals("") || price<0) {
				invalidInput();
				break;
			}

			alName.add(name);
			alPrice.add(price);

			System.out.println(">> 추가한 메뉴: "+name+"    가격: "+price+"\n");
		}
	}
	
	// 메뉴관리-메뉴수정 메소드
	public static void updateMenu(ArrayList<String> alName, ArrayList<Integer> alPrice) {
		Scanner si = new Scanner(System.in);
		Scanner	ss = new Scanner(System.in);
		
		while (true) {
			System.out.println("\t<메뉴목록>\n   메뉴\t\t가격");
			int i;
			for (i = 0; i < alName.size(); i++) {
				System.out.println((i+1)+". "+alName.get(i)+"\t\t"+alPrice.get(i));
			}
			System.out.println("");
			
			System.out.print("수정하고자 하는 메뉴번호 입력: ");
			int num=si.nextInt();
			if (num<1 || num>i) {
				invalidInput();
				break;
			}
			
			for (int j = 0; j < alName.size(); j++) {
				if (j==(num-1)) {
					System.out.print("새 메뉴명 입력: ");
					String newName=ss.nextLine();
					System.out.print("새 가격 입력: ");
					int newPrice=si.nextInt();
					
					if (newName.equals("") || newPrice<=0) {
						invalidInput();
						break;
					}
					System.out.println("");
					
					System.out.println("> 변경사항\n  메뉴: "+alName.get(j)+"->"+newName+", 가격: "+alPrice.get(j)+"->"+newPrice+"\n");

					alName.set(j, newName);
					alPrice.set(j, newPrice);
				}
			}
		}
	}
	
	// 메뉴관리-메뉴삭제 메소드
	public static void deleteMenu(ArrayList<String> alName, ArrayList<Integer> alPrice) {
		
		while (true) {
			System.out.println("\t<메뉴목록>\n   메뉴\t\t가격");
			int i;
			for (i = 0; i < alName.size(); i++) {
				System.out.println((i+1)+". "+alName.get(i)+"\t\t"+alPrice.get(i));
			}
			System.out.println("");
			
			System.out.print("삭제하고자 하는 메뉴번호 입력: ");
			String num=sc.nextLine();

			if (num.equals("")) { //여기서 (코드의 순서도 영향이 있음!) 
				invalidInput();
				break;
			}
			if (!isNumber(num)) {
				break;
			}
			int numMenu=Integer.parseInt(num); // 여기까지 => **유효성 검사
			
			if (numMenu<1 || numMenu>i) {
				invalidInput();
				break;
			}
			
			for (int j = 0; j < alName.size(); j++) {
				if (j==(numMenu-1)) {
					alName.remove(j);
					alPrice.remove(j);
				}
			}
		}
	}
	
	// 메뉴관리-메뉴보기 메소드
	public static void showMenu(ArrayList<String> alName, ArrayList<Integer> alPrice) {
		
		System.out.println("\t<메뉴목록>\n   메뉴\t\t가격");
		int i;
		for (i = 0; i < alName.size(); i++) {
			System.out.println((i+1)+". "+alName.get(i)+"\t\t"+alPrice.get(i));
		}
		System.out.println("");
	}
	
	
	// 주문관리 메소드 : 1.주문추가 2.주문삭제 3.주문보기 4.주문종료
	public static void doOrder(ArrayList<String> alName, ArrayList<Integer> alPrice, 
							   ArrayList<String> alMenu, ArrayList<Integer> alCount, ArrayList<Integer> alSum, ArrayList<String> alMobile) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("================\t <주문관리> \t================");
		
		System.out.println("\t<메뉴목록>\n   메뉴\t\t가격");
		int i;
		for (i = 0; i < alName.size(); i++) {
			System.out.println((i+1)+". "+alName.get(i)+"\t\t"+alPrice.get(i));
		}
		System.out.println("");
		
		while (true) {
			System.out.print("작업 선택 [c:주문추가, d:주문삭제, r:주문보기, x:종료] : ");
			String och=s.nextLine();		

			if (och.equals("x") || och.equals("X")) { // 종료
				break;
			}
			switch (och) {
			case "c","C":
				System.out.println(">>> 주문추가");
				addOrder(alName, alPrice, alMenu, alCount, alSum, alMobile);
				break;
			case "d","D":
				System.out.println(">>> 주문삭제");
				alMenu.clear();
				// ↓ == ↑  => 위에는 한번에 뭉텅이로 비워버리는 작동을 하고, 아래는 0번인덱스에 있는 값을 하나씩 지우는(어레이리스트는 인덱스가 사라지면 0-5 => 0-4 이런 식으로 줄어들기 때문에 0번 인덱스는 마지막까지 존재) 작동을 한다.
				//while (alMenu.size()>0) {
				//	System.out.println(alName.get(0));
				//	alName.remove(0);
				//}
				alCount.clear();
				alSum.clear();
				alMobile.clear();
				break;
			case "r","R":
				System.out.println(">>> 주문보기");
				showOrder(alMenu, alCount, alSum, alMobile);
				break;
			default:
				invalidInput();
				break;
			}
		}
	}
	
	// 주문관리-주문추가 메소드
	public static void addOrder(ArrayList<String> alName, ArrayList<Integer> alPrice, 
								ArrayList<String> alMenu, ArrayList<Integer> alCount, ArrayList<Integer> alSum, ArrayList<String> alMobile) {
		while (true) {
			
			System.out.print("주문할 메뉴번호 입력: ");
			String num=sc.nextLine();
			// 유효성검사
			if (num.equals("")) {
				invalidInput();
				break;
			}
			if (!isNumber(num)) {
				break;
			}
			int numMenu=Integer.parseInt(num);
			//
			if (numMenu<1 || numMenu>alName.size()) {
				invalidInput();
				break;
			}
			
			int sum=0;
			
			System.out.print("갯수 입력: ");
			String numC=sc.nextLine();
			//
			if (numC.equals("")) {
				invalidInput();
				break;
			}
			if (!isNumber(numC)) {
				break;
			}
			int numCount=Integer.parseInt(numC);
			//
			if (numCount<1) {
				invalidInput();
				break;
			}

			alMenu.add(alName.get(numMenu-1));
			alCount.add(numCount);

			sum=alPrice.get(numMenu-1)*numCount;
			alSum.add(sum);

			System.out.println(alMenu);
			System.out.println(alCount);
			System.out.println(alSum);
		}
		System.out.print("모바일번호 입력: ");
		String mobile=sc.nextLine();
		
		for (int i = 0; i < alMenu.size(); i++) {
			alMobile.add(mobile);
		}
		System.out.println(mobile);
		
	}
	
	// 주문관리-주문삭제 메소드
//	public static void deleteOrder() {
//		
//	}
	
	// 주문관리-주문보기 메소드
	public static void showOrder(ArrayList<String> alMenu, ArrayList<Integer> alCount, ArrayList<Integer> alSum, ArrayList<String> alMobile) {
		System.out.println("\t<주문확인>");
		
		int sum=0;
		for (int i = 0; i < alMenu.size(); i++) {
			System.out.println((i+1)+". "+alMenu.get(i)+" : "+alCount.get(i)+"개\t"+alSum.get(i)+"원");
			sum+=alSum.get(i);
			
			System.out.println("\t\t>> 총 결제금액: "+sum+"원\n\t\t   적립번호: "+alMobile.get(i));
			System.out.println("");
		}
	}
	
	
	// 매출관리 메소드 : 1.매출보기 2.완료
	public static void doSales(ArrayList<String> alName, ArrayList<Integer> alPrice, 
							   ArrayList<String> alMenu, ArrayList<Integer> alCount, ArrayList<Integer> alSum, ArrayList<String> alMobile) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("================\t <매출관리> \t================");
		
		while (true) {
			System.out.print("작업 선택 [r:매출보기, x:종료] : ");
			String sch=s.nextLine();
			
			if (sch.equals("x") || sch.equals("X")) { // 종료
				break;
			}
			switch (sch) {
			case "r","R":
				System.out.println(">>> 매출보기");
				showSales(alName, alPrice, alMenu, alCount, alSum, alMobile);
				break;
			default:
				invalidInput();
				break;
			}
		}
	}
	
	// 매출관리-매출보기 메소드
	public static void showSales(ArrayList<String> alName, ArrayList<Integer> alPrice, 
			   					 ArrayList<String> alMenu, ArrayList<Integer> alCount, ArrayList<Integer> alSum, ArrayList<String> alMobile) {
		System.out.println("주문메뉴\t수량\t금액\t적립번호");
		for (int i = 0; i < alMenu.size(); i++) {
			System.out.println(alMenu.get(i)+"\t"+alCount.get(i)+"\t"+alSum.get(i)+"\t"+alMobile.get(i));
		}
		
		
	}
	
}
