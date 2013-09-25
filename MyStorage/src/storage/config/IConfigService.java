package storage.config;

import storage.config.model.MemcachedConfig;
import storage.config.model.MysqlConfig;

public interface IConfigService {
	
	public MysqlConfig getMysqlConfig();
	
	public MemcachedConfig getMemcachedConfig();
}
