package com.wwd.main.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bioserver {
		
	public static void main(String[] args) throws IOException {
		ExecutorService exe = Executors.newCachedThreadPool();
		ServerSocket ss = new ServerSocket(10101);
		System.out.println("启动服务。。。");
		while(true) {
			final Socket socket = ss.accept();//这是一个阻塞点
			exe.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						handler(socket);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	public static void handler(Socket so) throws IOException {
		byte[] by = new byte[1024];
		InputStream  ins = so.getInputStream();
		while(true) {
			int len = ins.read(by);//阻塞点
			if(len != -1) {
				System.out.println(new String(by,0,len));
			}
		}
	}
}
