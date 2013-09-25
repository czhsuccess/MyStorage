package guice;

import com.google.inject.Inject;

public class MyWord {
	@Inject
	private HelloWorld sayhi;
	
	public String whatIsay() {
		return sayhi.sayHello();
	}
}
