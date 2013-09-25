package guice;

import com.google.inject.Inject;

public class Test {
	@Inject
	private static HelloWorld sayhi;
	
	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.sayhi.sayHello());
	}
}
