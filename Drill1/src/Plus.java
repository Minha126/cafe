import java.util.Scanner;

public class Plus {
	public static void main(String[] args) {
		
		/*
		 * 250109
		 */
	
		// 과제1) // 정수 a,b를 선언하고, Scanner를 이용해서 a,b값을 읽어들인다. // 정수 c를 선언하고, c에 a+b를저장한다. // c값을 출력한다.
		Scanner s1 = new Scanner(System.in);

//		System.out.println("<a + b = c 계산하기>\n");
//		 
//		int a;
//		int b;
//
//		System.out.print("a: ");
//		a=s1.nextInt();
//		 
//		System.out.print("b: ");
//		b=s1.nextInt();
//
//		int c;
//		c=a+b;
//		
//		System.out.println("c = " + c);
		 
		
		// 과제2) 문자열을 읽어들이고 다시 출력하는 프로그램

//		Scanner s2 = new Scanner(System.in);
//
//		String s;
//
//		System.out.print("문자를 입력하시오: ");
//		s = s2.nextLine();
//
//		System.out.println("\n입력하신 문자는 <" + s + "> 입니다.");

		// 과제3) 정수 a, 실수 b, 실수 c를 선언하고, a,b를 입력받고, c에 a*b를 저장한 후 c를 출력한다.
		
//		Scanner s3 = new Scanner(System.in);
//		
//		System.out.println("<x * y = z 계산하기>\n");
//
//		int x;
//		float y;
//		float z;
//		
//		System.out.print("정수 x: ");
//		x=s1.nextInt();
//		
//		System.out.print("실수 y: ");
//		y=s3.nextFloat();
//		
//		z=x*y;
//		System.out.println("z = " + z);
		
		/*
		 * 250110
		 */
		
		// byte < char < short < int < long < float < double
		
		int i;
		long j;
		
		j=24L;
		//i=j: // 에러발생
		i=(int)j; // 강제로 j를 정수형으로 맞춤 => 'casting 한다'라고 함.
		j=i; // 전혀 문제없이 잘 작동 => j가 i보다 사이즈가 더 크기 때문에
		
		float m;
		double n;
		
		m=1.5f;
		n=0.1;
		
		m=(float)n;
		
		int g=10;
		float h=2.0f;
		
		int d;
		//d=g+h; // 에러발생
		//d=(int)(g+h); // 가능하긴 함
		//d=g+(int)h; // warning이 발생하나 수행은 가능
		
		int q;
		float w;
		
		w=3.5f;
		
		q=(int)w;
		w=q;		
		
	}
}
