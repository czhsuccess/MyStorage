package storage.config.model;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MysqlConfig {
	private String url;
	private String user;
	private String pass;
	
	public MysqlConfig() {
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
			Iterator<?> itr = root.elementIterator("mysqlConfig");
			data = (Element) itr.next();

			url = data.elementText("url").trim();
			user = data.elementText("user").trim();
			pass = data.elementText("pass").trim();

		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}

	public synchronized String getUrl() {
		return url;
	}
	public synchronized String getUser() {
		return user;
	}
	public synchronized String getPass() {
		return pass;
	}
	
}
