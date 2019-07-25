package com.wwd.main.crawler.httpClient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class httpClientTest {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet get = new HttpGet("https://www.baidu.com");
		
		CloseableHttpResponse response = httpClient.execute(get);
		System.out.println(response.getStatusLine().getStatusCode());
		System.err.println("---------------");
	
		System.out.println(EntityUtils.toString(response.getEntity(),"utf-8"));	
	}
}
