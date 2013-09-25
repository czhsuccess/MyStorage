package storage.memcached;

import java.lang.reflect.Method;

import storage.AbstractOperation;
import storage.IOperation;
import storage.StorageInfo;

public class GetOperation extends AbstractOperation {
	IOperation operation;
	public GetOperation(StorageInfo info, Method method, IOperation operation) {
		super(info, method);
		this.operation = operation;
	}
	
	@Override
	public Object execute(final Object[] args) {
		String key = args[info.getKeyParameterIndex()].toString();
		
		Object result = MemcachedUtil.parseResult(key);
		
		if(null == result) {
			result = operation.execute(args);
			if(null != result) {
				byte[] bytes = encode(result);
				MemcachedUtil.parseResult(key, bytes, true);
			}
			
		}
		return decode((byte[])result);
	}
}
