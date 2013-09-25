package storage.mysql;

import java.lang.reflect.Method;

import storage.AbstractOperation;
import storage.StorageInfo;

public class GetOperation extends AbstractOperation {
	private final String sql;
	public GetOperation(StorageInfo info, Method method) {
		super(info, method);
		sql = "select value from `" + info.getStorageConfig().getTableName() + "` where `" + info.getKeyInfo() + "`=?";
	}
	
	@Override
	public Object execute(final Object[] args) {
		String key = args[info.getKeyParameterIndex()].toString();
		byte[] bytes = null;
		try {
			bytes = MysqlUtil.parseResult(sql, key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object obj = decode(bytes);
		return obj;
	}

}
