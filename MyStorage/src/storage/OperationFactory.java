package storage;

import java.lang.reflect.Method;

public interface OperationFactory {
	public IOperation getOperation(StorageInfo info, Method method);
}
