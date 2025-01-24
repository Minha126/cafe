import java.util.Scanner;

public class Sample {
	
	//static int a,b; // 전역변수 => 남발하는 것을 권하지 않음 => 코드에 혼란을 야기할 수 있음
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in); // 정수형
		
//		System.out.print("a값 입력: ");
//		int a=s.nextInt();
//		System.out.print("b값 입력: ");
//		int b=s.nextInt();
		
//		//plus(a,b);
//		int result=plus(a, b); // 변수명=메소드명();
//		System.out.println("result = c = "+result);
//		
//		a=3;
//		b=5;
//		result=plus(a, b); // 메소드 재활용

		/*
		 * 구구단 메소드 활용
		 */
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				String x=get(i, j);
				System.out.println(x);
			}
		}
		
//		System.out.print("a값 입력: ");
//		float n=s.nextFloat();
//		System.out.print("b값 입력: ");
//		int m=s.nextInt();
//
//		divide(n,m);
		
		
		
		
	}
	
//	public static int plus(int a, int b) { // ()안 변수를 파라미터(parameter)=매개변수라고 부름 => 1.호출부에서 보내는 값의 자료형과 받는 변수형이 같아야함. 2.호출부에서 보내는 값의 갯수와 받는 변수의 갯수도 같아야함.
//		int c=a+b;
//		//System.out.println(c);
//		return c; // 호출부로 값을 보내주는 역할 c->result	=> void 부분은 반환하는 값의 변수형을 적어줘야 함. 즉, c는 정수형이므로 int를 적어줘야함. void=>비어있음을 의미(즉, 리턴값이 없음)
//	}
	
	public static String get(int i, int j) {
		//System.out.println(i+" x "+j+" = "+(i*j)); // => 반환값이 없는 메소드 수행코드 
		
		//String k=i+" x "+j+" = "+(i*j); // => 반환값이 있는 메소드 수행코드 => 굳이 k는 선언하지 않아도 됨
		return i+" x "+j+" = "+(i*j);
	}
	
//	public static void divide(float x, int y) { // 반환값의 변수형에는 boolean형도 들어갈 수 있음. => True/False로 값을 반환(근데 문자열같은 타입이 아닌 boolean 타입임)
//		if (y==0) {
//			System.out.println("0으로 나누기 불가");
//			return;
//		}
//		System.out.println("나누기 결과 = "+(x/y));
//	}

}
