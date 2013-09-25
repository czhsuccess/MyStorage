package storage;

import java.lang.reflect.Method;

import storage.serialization.Serialize;

public abstract class AbstractOperation implements IOperation {
	protected final Method method;
	protected final StorageInfo info;
	
	public AbstractOperation(StorageInfo info, Method method) {
		this.method = method;
		this.info = info;
	}
	
	protected byte[] encode(Object obj) {
		return Serialize.object2Byte(obj);
	}
	
	protected Object decode(byte[] bytes) {
		return Serialize.byte2Object(bytes);
	}
}
