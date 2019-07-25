package com.wwd.main.xiancheng.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExcutorTransform{
	public static void main(String[] args) {
		
		  ExecutorService exec = Executors.newCachedThreadPool(); 
		  if(exec instanceof ThreadPoolExecutor) {
			  ((ThreadPoolExecutor) exec).setCorePoolSize(10);
		  }
		 
	
		
	}

}
