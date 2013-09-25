package storage.mysql;

import java.lang.reflect.Method;

import storage.IOperation;
import storage.OperationFactory;
import storage.OperationType;
import storage.StorageInfo;

public class DbOperationFactory implements OperationFactory {

	@Override
	public IOperation getOperation(StorageInfo info, Method method) {
		OperationType type = info.getType();
		switch (type) {
			case GET:
				return new GetOperation(info, method);
			case SET:
				return new SetOperation(info, method);
			case INSERT:
				return new InsertOperation(info, method);
			case DELETE:
				return new DeleteOperation(info, method);
		}
		return null;
	}

}
