package service.test;

import service.bean.ItemInfo;
import service.dao.DaoManager;
import storage.config.model.MysqlConfig;

public class Test {
	

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ItemInfo itemInfo = new ItemInfo();
		itemInfo.setItemId(1001);
		itemInfo.setPrice(45);
		itemInfo.setType(0);
	
		DaoManager.getItemDao().delete(1001);
//		System.out.println(DaoManager.getItemDao().get(1001).getPrice());
		
		
	}

}
