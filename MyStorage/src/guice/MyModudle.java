package guice;

import com.google.inject.AbstractModule;

public class MyModudle extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(HelloWorld.class).to(HelloWorldImp.class);
	}

}
