package storage.config;

public class ConfigManager {
	public static <T> T get(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		T object = (T)clazz.newInstance();
		return object;
	}
}
