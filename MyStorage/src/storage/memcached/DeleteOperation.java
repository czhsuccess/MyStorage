package storage.memcached;

import java.lang.reflect.Method;

import storage.AbstractOperation;
import storage.IOperation;
import storage.StorageInfo;

public class DeleteOperation extends AbstractOperation {
	private IOperation operation;
	public DeleteOperation(StorageInfo info, Method method, IOperation operation) {
		super(info, method);
		this.operation = operation;
	}
	
	@Override
	public Object execute(Object[] args) {
		String key = args[info.getKeyParameterIndex()].toString();
		boolean success = MemcachedUtil.remove(key);
		if(null != operation) {
			success = (boolean) operation.execute(args);
		}
		return success;
	}
}
