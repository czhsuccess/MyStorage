package storage.mysql;

import java.lang.reflect.Method;

import storage.AbstractOperation;
import storage.StorageInfo;

public class SetOperation extends AbstractOperation {
	private final String updateSql;
	
	public SetOperation(StorageInfo info, Method method) {
		super(info, method);
		updateSql = "update `" + info.getStorageConfig().getTableName() + "` set value=? where `" + info.getKeyInfo() + "`=?";
	}
	
	@Override
	public Object execute(Object[] args) {
		String key = args[info.getKeyParameterIndex()].toString();
		Object value = args[info.getValueParameterIndex()];
		byte[] bytes = encode(value);
		boolean success = false;
		try {
			success = MysqlUtil.parseResult(updateSql, key, bytes, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
}
