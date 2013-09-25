package storage.memcached;

import java.lang.reflect.Method;

import storage.IOperation;
import storage.OperationFactory;
import storage.OperationType;
import storage.StorageInfo;

public class CacheOperationFactory implements OperationFactory {
	private IOperation internalOperation;
	
	public CacheOperationFactory(IOperation operation) {
		this.internalOperation = operation;
	}
	
	public CacheOperationFactory() {
	}

	@Override
	public IOperation getOperation(StorageInfo info, Method method) {
		OperationType type = info.getType();
		switch(type) {
			case GET:
				return new GetOperation(info, method, internalOperation);
			case SET:
				return new SetOperation(info, method, internalOperation);
			case INSERT:
				return new InsertOperation(info, method, internalOperation);
			case DELETE:
				return new DeleteOperation(info, method, internalOperation);
		}
		return null;
	}
	
}
