package guice;

public class HelloWorldImp implements HelloWorld {

	@Override
	public String sayHello() {
		String s = "hello, usa";
		return s;
	}

}
