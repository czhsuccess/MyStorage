package storage.config;

import storage.config.model.MemcachedConfig;
import storage.config.model.MysqlConfig;

public class ConfigServiceImpl implements IConfigService {
	@Override
	public MysqlConfig getMysqlConfig() {
		try {
			return ConfigManager.get(MysqlConfig.class);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public MemcachedConfig getMemcachedConfig() {
		try {
			return ConfigManager.get(MemcachedConfig.class);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
