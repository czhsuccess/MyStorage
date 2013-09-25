package service.dao;

import service.bean.ItemInfo;
import storage.OperationType;
import storage.anno.Ckey;
import storage.anno.Cvalue;
import storage.anno.Storage;

public interface ItemDao {
	final String key = "itemId";
	@Storage(type = OperationType.GET, configKey = "itemConfig")
	public ItemInfo get(@Ckey(value = key) long itemId);
	
	@Storage(type = OperationType.SET, configKey = "itemConfig")
	public void set(@Ckey(value = key) long itemId, @Cvalue ItemInfo itemInfo);
	
	@Storage(type = OperationType.INSERT, configKey = "itemConfig")
	public void insert(@Ckey(value = key) long itemId, @Cvalue ItemInfo itemInfo);
	
	@Storage(type = OperationType.DELETE, configKey = "itemConfig")
	public void delete(@Ckey(value = key) long itemId);
}
