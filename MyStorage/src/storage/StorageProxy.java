package storage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import storage.StorageInfo;
import storage.anno.Ckey;
import storage.anno.Cvalue;
import storage.anno.Storage;
import storage.memcached.CacheOperationFactory;
import storage.mysql.DbOperationFactory;

public class StorageProxy implements MethodInterceptor {
	
	/* 获取DbOperationFactory对象 */
	DbOperationFactory dbOperationFactory = new DbOperationFactory();
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		StorageInfo storageInfo = new StorageInfo();
		/* 解析方法上的注解放入StorageInfo中*/
		Storage storage = method.getAnnotation(Storage.class);
		storageInfo.setType(storage.type());
		String configKey = storage.configKey();
		storageInfo.setStorageConfig(StorageFactory.getStorageConfig(configKey));
		int paramIndex = 0;
		for(Annotation[] anos : method.getParameterAnnotations()){
			for(Annotation ano : anos) {
				if(ano instanceof Ckey) {
					storageInfo.setKeyParameterIndex(paramIndex);
					storageInfo.setKeyInfo(((Ckey) ano).value());
				}
				
				if(ano instanceof Cvalue) {
					storageInfo.setValueParameterIndex(paramIndex);
				}
			}
			paramIndex++;
		}
			
		IOperation operation = null;
		if(storageInfo.getStorageConfig().dbEnable()) {
			operation = dbOperationFactory.getOperation(storageInfo, method);
			if(storageInfo.getStorageConfig().cacheEnable()) {
				CacheOperationFactory cacheOperationFactory = new CacheOperationFactory(operation);
				operation = cacheOperationFactory.getOperation(storageInfo, method);
			}
		} else if(storageInfo.getStorageConfig().cacheEnable()) {
			CacheOperationFactory cacheOperationFactory = new CacheOperationFactory();
			operation = cacheOperationFactory.getOperation(storageInfo, method);
		}

		return operation.execute(args);
	}
	
}
