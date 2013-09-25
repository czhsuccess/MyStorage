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
        //创建一个连接池
        SockIOPool pool = SockIOPool.getInstance();
        //设置缓存服务器
        pool.setServers(servers);
        //设置初始化连接数，最小连接数，最大连接数以及最大处理时间
        pool.setInitConn(config.getInitConn());
        pool.setMinConn(config.getMinConn());
        pool.setMaxConn(config.getMaxConn());
        pool.setMaxIdle(config.getMaxIdle());
        //设置主线程睡眠时间，每3秒苏醒一次，维持连接池大小
        //maintSleep 千万不要设置成30，访问量一大就出问题，单位是毫秒，推荐30000毫秒。
        pool.setMaintSleep(config.getMaintSleep());
        //关闭套接字缓存
        pool.setNagle(config.isNagle());
        //连接建立后的超时时间
        pool.setSocketTO(config.getSocketTO());
        //连接建立时的超时时间
        pool.setSocketConnectTO(config.getSocketConnectTO());
        //初始化连接池
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
