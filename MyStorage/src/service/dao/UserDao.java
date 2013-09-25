package service.dao;

import storage.OperationType;
import storage.anno.Ckey;
import storage.anno.Cvalue;
import storage.anno.Storage;
import service.bean.UserInfo;

public interface UserDao {
	final String key = "uid";
	@Storage(type = OperationType.GET, configKey = "userConfig")
	public UserInfo get(@Ckey(value = key) long uid);
	
	@Storage(type = OperationType.SET, configKey = "userConfig")
	public void set(@Ckey(value = key) long uid, @Cvalue UserInfo userInfo);
	
	@Storage(type = OperationType.INSERT, configKey = "userConfig")
	public void insert(@Ckey(value = key) long uid, @Cvalue UserInfo userInfo);
}
