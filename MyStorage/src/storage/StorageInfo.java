package storage;

public class StorageInfo {
	/* 操作类型，get、set等 */
	private OperationType type;
	/* key参数，均为String型 */
	private int keyParameterIndex;
	/* value参数索引，-1表示无value信息 */
	private int valueParameterIndex = -1;
	/* 存储配置 */
	private StorageConfig storageConfig;
	/* 需要操作的列信息 */
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
