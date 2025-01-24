import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		
		Scanner s1 = new Scanner(System.in); // 정수형
		Scanner s2 = new Scanner(System.in); // 문자열
		
		/*
		 * ArrayList - 예제1
		 * 
		 * 이름, 나이 입력받고 출력하기
		 */
		
//		ArrayList<String> alname = new ArrayList<String>();
//		ArrayList<Integer> alage = new ArrayList<Integer>();
//		
//		while (true) {
//			System.out.print("이름: ");
//			String name=s2.nextLine();
//			System.out.print("나이: ");
//			int age=s1.nextInt();
//			
//			if (name.equals("") || age<1) {
//				System.out.println(">>> 잘못된 입력입니다.\n");
//				break;
//			}
//			
//			System.out.println("");
//			alname.add(name);
//			alage.add(age);
//		}
//		
//		System.out.println("<목록>\n이름\t나이\n------------");
//		for (int i = 0; i < alname.size(); i++) {
//			System.out.println(alname.get(i)+"\t"+alage.get(i));
//		}
		
		/*
		 * ArrayList - 예제2
		 * 
		 * 메뉴명,가격 입력/출력 프로그램
		 */
		
//		ArrayList<String> alMenu = new ArrayList<String>();
//		ArrayList<Integer> alPrice = new ArrayList<Integer>();
//		
//		while (true) {
//			System.out.print("메뉴명 입력: ");
//			String menu=s2.nextLine();
//			System.out.print("가격 입력: ");
//			int price=s1.nextInt();
//
//			if (menu.equals("") || price<0) {
//				System.out.println(">>> 잘못된 입력으로 프로그램 종료");
//				break;
//			}
//			System.out.println("");
//			alMenu.add(menu);
//			alPrice.add(price);
//			
//		}
//		System.out.println("\n메뉴\t가격");
//		System.out.println("----------------");
//		for (int i = 0; i < alMenu.size(); i++) { // 다르게 쓸 수 있는 조건: i<alMenu.size() && i<alPrice.size();
//			System.out.println(alMenu.get(i)+"\t"+alPrice.get(i));
//		}
		
		/*
		 * for문 - 예제1
		 * 
		 * 1부터 100까지의 합 구하기
		 */
		
//		int sum=0;
//		for (int i = 0; i <= 100; i++) {
//			sum += i;
//		}
//		System.out.print("총합: "+sum);
		
		/*
		 * for문 - 예제2
		 * 
		 * 구구단 전체(2~9단)를 출력 
		 */
		
//		for (int i = 2; i < 10; i++) {
//			System.out.println("<"+i+"단>");
//			for (int j = 1; j < 10; j++) {
//				System.out.println(i+" x "+j+" = "+(i*j));
//			}
//		}
		
		/*
		 * do-while문 - 예제1
		 * 
		 * 문자열 읽기
		 * 문자열이 'x'가 아닌 동안
		 * 'm' -> "메뉴추가" 출력
		 * 'o' -> "주문" 출력
		 * 's' -> "매출 실적" 출력
		 * else Do nothing
		 * 문자열 읽기
		 * 프로그램 종료 출력
		 */
		// while문-switch로도 코딩 가능
		
//		String c="";
//		
//		do {
//			System.out.print("문자 입력: ");
//			c=s2.nextLine();
//			if (c.equals("x") || c.equals("X")) {
//				System.out.println("프로그램 종료");
//			} else if (c.equals("m") || c.equals("M")) {
//				System.out.println("메뉴 추가");
//			} else if (c.equals("o") || c.equals("O")) {
//				System.out.println("주문");
//			} else if (c.equals("s") || c.equals("S")) {
//				System.out.println("매출 실적");
//			} else {
//				System.out.println("Do nothing");
//			}
//			
//		} while (!c.equals("x") && !c.equals("X"));  // while (!(c.equals("x") || c.equals("X")));
		
		/*
		 * for문 - 예제3
		 * 
		 * 100이하의 소수 찾기
		 */
		
//		System.out.print("수 입력: ");
//		int num=s1.nextInt();
//		
//		int notPrime=0;		
//		for (int i = 2; i <= num; i++) {
//			for (int j = 2; j < i; j++) {
//				if (i%j==0) {
//					System.out.println(i+" -> 소수X");
//					notPrime=i;
//					break;
//				}
//				/* 방법2)
//				 * if (j==(i-1)) {
//				 * 	System.out.println(i+" -> 소수");
//				 * }
//				 */
//			}
//			// 방법1) -myself
//			if (notPrime!=i) {
//				System.out.println(i+" -> 소수");
//			}
//		}
		
		// 방법3)
//		for (int i = 2; i <= num; i++) {
//			int j;
//			for (j = 2; j < i; j++) {
//				if (i%j==0) {
//					System.out.println(i+" -> 소수X");
//					break;
//				}
//			}
//			if (i==j) {
//				System.out.println(i+" -> 소수");
//			}
//		}
		
		/*
		 * for문 - 예제4
		 * 
		 * arNum |10|4|5|12|7|
		 * -> 오름차순으로 정렬
		 * 기준: 0번 인덱스
		 * 시작: 1번 인덱스
		 * 끝: 마지막 인덱스
		 * 
		 * 방법: 0번 인덱스가 1번 인덱스보다 큰가? 아니:유지, 응:바꾸기 -> 0번 인덱스가 2번 인덱스보다 큰가? O/X 로 쭉 진행해서 정렬
		 */
		
		int[] arNum = {10,4,5,12,7};
		
		for (int base = 0; base < arNum.length-1; base++) {
			for (int start = base+1; start < arNum.length; start++) {
				if (arNum[base]>arNum[start]) {
					int tmp;
					tmp=arNum[base];
					arNum[base]=arNum[start];
					arNum[start]=tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arNum)); // 배열 뭉텅이로 출력하는 법: Arrays.toString(배열명)
		
	}

}


