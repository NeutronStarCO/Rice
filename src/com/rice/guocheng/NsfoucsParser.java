/* 
 * @(#)NsfoucsParser.java	27/03/14 
 * 
 * Copyright 2014 Cheng GUO. All rights reserved. 
 * Use is subject to license terms. 
 */  
package com.rice.guocheng;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/** 
 * Class <code>NsfoucsParser</code>. 
 * 
 * @author  Cheng GUO 
 * @version 0.1, 27/03/14 
 * @see     com.guocheng 
 * @since   JDK1.6 
 */  
public class NsfoucsParser {
	/** The value is used for URL storage. */ 
	private URL myURL;
	private String url;
	private String v5_product_host;
	private String user = "conadmin";
	private String password = "iamaurora";
	private String id = "14200";
	private String lang = "zh_CN";
	
	
	private String ns_class = "";

	public NsfoucsParser() 
	{    
		loadConfigure();
	}
	
	public void loadConfigure()
	{
		// 读取configure文件中的参数
		
		url = "https://" + v5_product_host + "/httpRpc/deltask?user=" + user + "&password=" + password;
	}
	
	/**
	 * 联动约定
	 * @param 
	 * @return	<错误号>:<提示信息>
	 */
	public String shakeHands()
	{
		StringBuffer result = new StringBuffer();
		try {
			// 创建URL对象
			myURL = new URL(url + "?id=" + id + "?lang=" + lang);
			// 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
	        HttpsURLConnection httpsConn = (HttpsURLConnection) myURL.openConnection();
	        // 取得该连接的输入流，以读取响应内容
	        BufferedReader reader=new BufferedReader(new InputStreamReader(httpsConn.getInputStream(),"utf-8"));
	        // 读取服务器的响应内容并显示        
	        String line = null;
            while((line=reader.readLine()) !=null)
            	result.append(line);
                reader.close();            
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result.toString();
	}
	
	/**
	 * 联动启动任务
	 * @param 
	 * @return	<错误号>:<提示信息>
	 */
	public String createTasks(String templateid)
	{
		StringBuffer result = new StringBuffer();
		try {
			// 创建URL对象
			myURL = new URL(url + "&targets=" + targets + "?templateid=" + templateid + "?class=" + ns_class);
			// 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
	        HttpsURLConnection httpsConn = (HttpsURLConnection) myURL.openConnection();
	        // 取得该连接的输入流，以读取响应内容
	        BufferedReader reader=new BufferedReader(new InputStreamReader(httpsConn.getInputStream(),"utf-8"));
	        // 读取服务器的响应内容并显示        
	        String line = null;
            while((line=reader.readLine()) !=null)
            	result.append(line);
                reader.close();            
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.print("Start");
		NsfoucsParser np = new NsfoucsParser();

	}

}
