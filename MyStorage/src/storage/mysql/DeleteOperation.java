package storage.mysql;

import java.lang.reflect.Method;

import storage.AbstractOperation;
import storage.StorageInfo;

public class DeleteOperation extends AbstractOperation {
	private final String sql;
	public DeleteOperation(StorageInfo info, Method method) {
		super(info, method);
		sql = "delete from `" + info.getStorageConfig().getTableName() + "` where `" + info.getKeyInfo() + "`=?";
	}

	@Override
	public Object execute(Object[] args) {
		String key = args[info.getKeyParameterIndex()].toString();
		return MysqlUtil.parseResult(sql, key, true);
	}

}
