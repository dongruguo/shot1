package com.wwd.main.xiancheng.cache;

import java.util.HashMap;

public class Memoizerl<A,V> implements Computable<A,V> {
	private final HashMap<A,V> cache = new HashMap<A,V>();
	private final Computable<A,V> C;
	public Memoizerl(Computable<A,V> c) {
		this.C = c;
	}
	@Override
	public V compute(A arg) {
		// TODO Auto-generated method stub
		V result = cache.get(arg);
		if(result == null) {
			result = C.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}
	

}
