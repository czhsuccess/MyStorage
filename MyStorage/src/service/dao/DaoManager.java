package service.dao;

import storage.StorageFactory;

public class DaoManager {
	static{
		StorageFactory.registStorageConfig(StorageConfigEnum.values());
	}
	
	public static UserDao getUserDao() {
		return StorageFactory.getDao(UserDao.class);
	}
	
	public static ItemDao getItemDao() {
		return StorageFactory.getDao(ItemDao.class);
	}
}
