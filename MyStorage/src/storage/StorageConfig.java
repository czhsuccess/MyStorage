package storage;

public interface StorageConfig {
	/* storageConfigKey��ʾΨһ�Ĵ洢���� */
	public String getStorageConfigKey();
	
	/* �Ƿ���Ҫ����memcached */
	public boolean cacheEnable();
	
	/* �Ƿ���Ҫ���������ݿ��� */
	public boolean dbEnable();
	
	/* �洢��db�еı��� */
	public String getTableName();
}
