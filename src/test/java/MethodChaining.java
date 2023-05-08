
public class MethodChaining {

	public static void main(String[] args) {
		
//		MethodChaining m1 = new MethodChaining();
//		m1.a1().a2().a3();
		
		a1().a2().a3();
		
	}
	
	public static MethodChaining a1() {
		System.out.println("This is a1");
		return new MethodChaining();
	}
	
	public  MethodChaining a2() {
		System.out.println("This is a2");
		return new MethodChaining();
	}
	
	public  MethodChaining a3() {
		System.out.println("This is a3");
		return new MethodChaining();
	}
}

