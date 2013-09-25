package service.dao;

import storage.StorageConfig;

public enum StorageConfigEnum implements StorageConfig {
	USER_CONF("userConfig", "user", true, true),
	ITEM_CONF("itemConfig", "item", false, true),
	USER_FRIEND_LIST("userFriendConfig", "friendlist", true, false),
	;
	
	private String configKey;
	private String tableName;
	private boolean cacheEnable;
	private boolean dbEnable;
	
	StorageConfigEnum(String configKey, String tableName, boolean cacheEnable, boolean dbEnable){
		this.configKey = configKey;
		this.tableName = tableName;
		this.cacheEnable = cacheEnable;
		this.dbEnable = dbEnable;
	}

	@Override
	public boolean cacheEnable() {
		return cacheEnable;
	}

	@Override
	public String getStorageConfigKey() {
		return configKey;
	}

	@Override
	public String getTableName() {
		return tableName;
	}

	@Override
	public boolean dbEnable() {
		return dbEnable;
	}

}
