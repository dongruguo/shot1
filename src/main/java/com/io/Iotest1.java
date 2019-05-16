package com.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class Iotest1 {
	
	@Test
	public void test1() throws Exception{
		String path = "C:/Users/Administrator\\Desktop/汉王手写液晶屏集成福昕/安装说明.txt";
		//下面方法读取中文会乱码
		/*FileReader fr = new FileReader(path);
		char[] buf = new char[1024];
		int len ;
		while((len = fr.read(buf))!=-1) {
			System.out.println(new String(buf,0,len));
		}*/
		InputStreamReader isr = new InputStreamReader(new FileInputStream(path) ,"GBK");
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(isr);
		char[] buf = new char[1024];
		int len ;
		String rl;
		/*while((len = isr.read(buf))!=-1) {
			System.out.println(new String(buf,0,len));
		}*/
		System.out.println("-------------------------");
		while((rl = br.readLine())!=null) {
			System.out.println(rl);
		}
	}
}
