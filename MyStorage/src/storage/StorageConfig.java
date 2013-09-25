package storage;

public interface StorageConfig {
	/* storageConfigKey表示唯一的存储配置 */
	public String getStorageConfigKey();
	
	/* 是否需要存在memcached */
	public boolean cacheEnable();
	
	/* 是否需要存贮在数据库中 */
	public boolean dbEnable();
	
	/* 存储在db中的表名 */
	public String getTableName();
}
