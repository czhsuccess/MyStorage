package storage.memcached;

import java.lang.reflect.Method;

import storage.AbstractOperation;
import storage.IOperation;
import storage.StorageInfo;

public class SetOperation extends AbstractOperation {
	IOperation operation;
	public SetOperation(StorageInfo info, Method method, IOperation operation) {
		super(info, method);
		this.operation = operation;
	}
	@Override
	public Object execute(Object[] args) {
		String key = args[info.getKeyParameterIndex()].toString();
		Object value = args[info.getValueParameterIndex()];
		byte[] bytes = encode(value);
		MemcachedUtil.parseResult(key, bytes, false);
		
		if(null != operation) {
			try{
				return operation.execute(args);
			} catch (RuntimeException e) { //持久化失败后要删除cache中的内容
				MemcachedUtil.remove(key);
				throw e;
			}
		}
		return true;
	}
}
