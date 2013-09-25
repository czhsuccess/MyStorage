package storage;

public class StorageInfo {
	/* �������ͣ�get��set�� */
	private OperationType type;
	/* key��������ΪString�� */
	private int keyParameterIndex;
	/* value����������-1��ʾ��value��Ϣ */
	private int valueParameterIndex = -1;
	/* �洢���� */
	private StorageConfig storageConfig;
	/* ��Ҫ����������Ϣ */
	private String keyInfo;
	
	public synchronized OperationType getType() {
		return type;
	}
	public synchronized void setType(OperationType type) {
		this.type = type;
	}
	public synchronized int getKeyParameterIndex() {
		return keyParameterIndex;
	}
	public synchronized void setKeyParameterIndex(int keyParameterIndex) {
		this.keyParameterIndex = keyParameterIndex;
	}
	public synchronized int getValueParameterIndex() {
		return valueParameterIndex;
	}
	public synchronized void setValueParameterIndex(int valueParameterIndex) {
		this.valueParameterIndex = valueParameterIndex;
	}
	public synchronized StorageConfig getStorageConfig() {
		return storageConfig;
	}
	public synchronized void setStorageConfig(StorageConfig storageConfig) {
		this.storageConfig = storageConfig;
	}
	public synchronized String getKeyInfo() {
		return keyInfo;
	}
	public synchronized void setKeyInfo(String keyInfo) {
		this.keyInfo = keyInfo;
	}
}
