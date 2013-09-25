package storage.config.model;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MemcachedConfig {
	private String[] servers;
	private int initConn;
	private int minConn;
	private int maxConn;
	private long maxIdle;
	private int maintSleep;
	private boolean nagle;
	private int socketTO;
	private int socketConnectTO;
	
	public MemcachedConfig() {
		String mysqlConfigFile = "src/storage/config/configFile/conf.xml";
		try {
			File f = new File(mysqlConfigFile);
			if (!f.exists()) {
				System.out.println("  Error : Config file doesn't exist!");
				System.exit(1);
			}
			SAXReader reader = new SAXReader();
			Document doc;
			doc = reader.read(f);
			Element root = doc.getRootElement();
			
			Element data;
			Iterator<?> itr = root.elementIterator("memcachedConfig");
			data = (Element) itr.next();

			initConn = Integer.parseInt(data.elementText("initConn").trim());
			minConn = Integer.parseInt(data.elementText("minConn").trim());
			maxConn = Integer.parseInt(data.elementText("maxConn").trim());
			maxIdle = Long.parseLong(data.elementText("maxIdle").trim());
			maintSleep = Integer.parseInt(data.elementText("maintSleep").trim());
			socketTO = Integer.parseInt(data.elementText("socketTO").trim());
			socketConnectTO = Integer.parseInt(data.elementText("socketConnectTO").trim());
			if(data.elementText("maxIdle").trim().equals(true))
				nagle = true;
			else nagle = false;
			
			List<?> serverList = data.elements("servers");
			servers = new String[serverList.size()];
			for(int i = 0; i < serverList.size(); i++) {
				servers[i] = ((Element)serverList.get(i)).elementText("server");
			}
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}

	public synchronized String[] getServers() {
		return servers;
	}
	public synchronized int getInitConn() {
		return initConn;
	}
	public synchronized int getMinConn() {
		return minConn;
	}
	public synchronized int getMaxConn() {
		return maxConn;
	}
	public synchronized long getMaxIdle() {
		return maxIdle;
	}
	public synchronized int getMaintSleep() {
		return maintSleep;
	}
	public synchronized boolean isNagle() {
		return nagle;
	}
	public synchronized int getSocketTO() {
		return socketTO;
	}
	public synchronized int getSocketConnectTO() {
		return socketConnectTO;
	}
}