package storage.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {
	public static byte[] object2Byte(Object obj) {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);

            bytes = bo.toByteArray();

            bo.close();
            oo.close();
        } catch (Exception e) {
            System.out.println("序列化出错了。。。" + e.getMessage());
            e.printStackTrace();
        }
        return bytes;
    }
	
	public static Object byte2Object(byte[] bytes) {
        Object obj = null;
		try {
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);
            obj = oi.readObject();

            bi.close();
            oi.close();
            
        } catch (Exception e) {
            System.out.println("反序列化出错了。。。" + e.getMessage());
            e.printStackTrace();
        }
		return obj;
    }
}
