package storage.memcached;

import storage.config.ConfigServiceImpl;
import storage.config.IConfigService;
import storage.config.model.MemcachedConfig;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MemcachedUtil {
	private static MemCachedClient memCachedClient = new MemCachedClient();
	
	private static IConfigService configService = new ConfigServiceImpl();
	
	static {
		MemcachedConfig config = configService.getMemcachedConfig();
        String[] servers = config.getServers();
        //����һ�����ӳ�
        SockIOPool pool = SockIOPool.getInstance();
        //���û��������
        pool.setServers(servers);
        //���ó�ʼ������������С������������������Լ������ʱ��
        pool.setInitConn(config.getInitConn());
        pool.setMinConn(config.getMinConn());
        pool.setMaxConn(config.getMaxConn());
        pool.setMaxIdle(config.getMaxIdle());
        //�������߳�˯��ʱ�䣬ÿ3������һ�Σ�ά�����ӳش�С
        //maintSleep ǧ��Ҫ���ó�30��������һ��ͳ����⣬��λ�Ǻ��룬�Ƽ�30000���롣
        pool.setMaintSleep(config.getMaintSleep());
        //�ر��׽��ֻ���
        pool.setNagle(config.isNagle());
        //���ӽ�����ĳ�ʱʱ��
        pool.setSocketTO(config.getSocketTO());
        //���ӽ���ʱ�ĳ�ʱʱ��
        pool.setSocketConnectTO(config.getSocketConnectTO());
        //��ʼ�����ӳ�
        pool.initialize();
	}

	public static MemCachedClient getMemCachedClient() {
		return memCachedClient;
	}
	
	public static Object parseResult(String key) {
		return memCachedClient.get(key);
	}
	
	public static boolean parseResult(String key, byte[] value, boolean isAdd) {
		if(isAdd) {
			return memCachedClient.add(key, value);
		} else {
			return memCachedClient.set(key, value);
		}
	}
	
	public static boolean remove(String key) {
		return memCachedClient.delete(key);
	}
	
	public static void main(String[] args) {
		System.out.println(configService.getMemcachedConfig().getServers()[0]);
	}
}
