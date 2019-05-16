package com.suncnpap.framework.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装easyui的datagrid和treegrid显示
 * datagrid 调用datagrid
 * treegrid 调用treegrid
 * @author chenl
 *
 */
public class Client<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer total;
	private List<T> rows ;
	
	private Map<String,Object> obj = new HashMap<String,Object>();
	
	@SuppressWarnings("rawtypes")
	public Client(){
		total = 0;
		rows = new ArrayList();
	}
	
	/**
	 * 将数据封装成datagrid所需要的数据
	 * @return
	 */
	public Map<String,Object> datagrid(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", total);
		map.put("rows", rows);
		map.put("obj", obj);
		return map;
	}
	
	/**
	 * 显示treegrid数据
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List treegrid(){
		return rows;
	}
	
	
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	/**
	 * 将page中的datalist 和totalResult自动封装
	 * @param page
	 */
	/*public void setPage(Page page) {
		// TODO Auto-generated method stub
		this.setRows(page.getDataList());
		this.setTotal(page.getTotalResult());
	}*/
	
	public void put(String key,Object obj) {
		this.obj.put(key, obj);
	}
	
}
