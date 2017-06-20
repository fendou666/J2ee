package chinasofti.commons;

import java.text.DecimalFormat;

public class MyStatic {
	
	public static final double PI = 3.1415926;

	public static void staticmethod() {
		System.out.println("it is static method");
		DecimalFormat df = new DecimalFormat(".00");
	}
	
	public static void a() {
		System.out.println("----------------------");
	}
}
