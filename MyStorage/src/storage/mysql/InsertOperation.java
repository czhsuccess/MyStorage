package storage.mysql;

import java.lang.reflect.Method;

import storage.AbstractOperation;
import storage.StorageInfo;

public class InsertOperation extends AbstractOperation {
	private final String insertSql;
	public InsertOperation(StorageInfo info, Method method) {
		super(info, method);
		insertSql = "insert into `" + info.getStorageConfig().getTableName() + "` values(?,?)";
	}

	@Override
	public Object execute(Object[] args) {
		String key = args[info.getKeyParameterIndex()].toString();
		Object value = args[info.getValueParameterIndex()];
		byte[] bytes = encode(value);
		boolean success = false;
		try {
			success = MysqlUtil.parseResult(insertSql, key, bytes, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

}
