/**
 * 
 */
/**
 * @author Fogman
 *
 */
package com.phexum.eclipse.plugin.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.eclipse.core.resources.ResourcesPlugin;



public class PluginProperties {
	private static final String PROP_PATH = // System.getProperty("user.dir") + "/config.properties";
			"C:/Users/kutay/Desktop/config.properties";
	private static String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
	private static Properties prop = new Properties();
	
	private static final String KEY_HOST="engine.url";
	private static final String KEY_FILE_PORT="engine.file.port";
	
	public static String getWorkspacePath() {
		return workspacePath;
	}
	
	private static String HOST="localhost", FILE_PORT="1993";
	
	static {
		loadProperties();
	} 
	
	public static void saveProperties() {
		
		OutputStream output = null;
		
		try {
			output = new FileOutputStream(PROP_PATH);
			
			prop.setProperty(KEY_HOST, HOST);
			prop.setProperty(KEY_FILE_PORT, FILE_PORT);
			prop.store(output, null);
			
		} catch (IOException io) {
			io.printStackTrace();
		} finally { // finally neydi bak
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void loadProperties() {
		InputStream input = null;
		
		try {
			
			input = new FileInputStream(PROP_PATH);
			prop.load(input);
			HOST = prop.getProperty(KEY_HOST);
			FILE_PORT = prop.getProperty(KEY_FILE_PORT); // prop ne bak
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String getHost() {
		return HOST;
	}
	
	public static void setHost(String u) {
		HOST = u;
	}
	
	public static String getFilePort() {
		return FILE_PORT;
	}
	
	public static void setFilePort(String p) {
		FILE_PORT = p;
	}
	
}

