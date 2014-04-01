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
		// ��ȡconfigure�ļ��еĲ���
		
		url = "https://" + v5_product_host + "/httpRpc/deltask?user=" + user + "&password=" + password;
	}
	
	/**
	 * ����Լ��
	 * @param 
	 * @return	<�����>:<��ʾ��Ϣ>
	 */
	public String shakeHands()
	{
		StringBuffer result = new StringBuffer();
		try {
			// ����URL����
			myURL = new URL(url + "?id=" + id + "?lang=" + lang);
			// ����HttpsURLConnection���󣬲�������SSLSocketFactory����
	        HttpsURLConnection httpsConn = (HttpsURLConnection) myURL.openConnection();
	        // ȡ�ø����ӵ����������Զ�ȡ��Ӧ����
	        BufferedReader reader=new BufferedReader(new InputStreamReader(httpsConn.getInputStream(),"utf-8"));
	        // ��ȡ����������Ӧ���ݲ���ʾ        
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
	 * ������������
	 * @param 
	 * @return	<�����>:<��ʾ��Ϣ>
	 */
	public String createTasks(String templateid)
	{
		StringBuffer result = new StringBuffer();
		try {
			// ����URL����
			myURL = new URL(url + "&targets=" + targets + "?templateid=" + templateid + "?class=" + ns_class);
			// ����HttpsURLConnection���󣬲�������SSLSocketFactory����
	        HttpsURLConnection httpsConn = (HttpsURLConnection) myURL.openConnection();
	        // ȡ�ø����ӵ����������Զ�ȡ��Ӧ����
	        BufferedReader reader=new BufferedReader(new InputStreamReader(httpsConn.getInputStream(),"utf-8"));
	        // ��ȡ����������Ӧ���ݲ���ʾ        
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
