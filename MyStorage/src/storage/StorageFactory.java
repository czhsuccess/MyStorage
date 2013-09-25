package storage;

import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.proxy.Enhancer;

public class StorageFactory {
	/* ¥Ê¥¢≈‰÷√À˘‘⁄µƒmap */
	private final static Map<String, StorageConfig> configMap = new HashMap<String, StorageConfig>();
	
	/* ◊¢≤·¥Ê¥¢≈‰÷√ */
	public static void registStorageConfig(StorageConfig[] configs) {
		for(StorageConfig config : configs) {
			configMap.put(config.getStorageConfigKey(), config);
		}
	}
	
	public static StorageConfig getStorageConfig(String configKey) {
		return configMap.get(configKey);
	}
	
	public static <T> T getDao(Class<T> clazz) {
		Enhancer eh = new Enhancer();
		eh.setSuperclass(clazz);
		eh.setCallback(new StorageProxy());
		T proxy = (T)eh.create();
		return proxy;
	}
}
