package com.wwd.main.JavaJVM;

import java.io.IOException;
import java.io.InputStream;

public class CLassLoaderTest {
			public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
				ClassLoader myloader = new ClassLoader() {
					@Override
					public Class<?> loadClass(String name) throws ClassNotFoundException{
						try {
							String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
							InputStream is = getClass().getResourceAsStream(fileName);
							if(is==null) {
								return super.loadClass(name);
							}
							byte[] b = new byte[is.available()];
							is.read(b);
							return defineClass(name,b,0,b.length);
						}catch(IOException e) {
							throw new ClassNotFoundException(name);
						}
					}
				};
				Object object = myloader.loadClass("JavaJVM.CLassLoaderTest").newInstance();
				System.out.println(object.getClass());
				System.out.println(object instanceof com.wwd.main.JavaJVM.CLassLoaderTest);
			}
			
}
