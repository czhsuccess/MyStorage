package service.bean;

import java.io.Serializable;

/**
 * @author ÆÕÈðÃ÷ÌØ
 *
 */
public class ItemInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long itemId;
	int price;
	int type;
	
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
