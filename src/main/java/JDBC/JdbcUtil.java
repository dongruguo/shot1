package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JdbcUtil {
	
	private String dataType;
	private String url;
	private String username;
	private String password;
	
	
	//自定义数据库信息
	public JdbcUtil(String dataType,String url,String username,String password) {
		this.dataType =dataType;
		this.url = url;//"jdbc:mysql://localhost:3306/RUNOOB";
		this.username = username;
		this.password = password;
		
	}
	
		
	public Connection getConnection() {
		
		String driverClassName = "";
		
		if(dataType.equals("mysql")) {
			driverClassName = "com.mysql.jdbc.Driver";
		}else if(dataType.equals("oracle")) {
			driverClassName = "oracle.jdbc.driver.OracleDriver";
		}else if(dataType.equals("sqlserver")) {
			driverClassName = "net.sourceforge.jtds.jdbc.Driver";
		}								
		Connection conn = null;
		try {
			//加载驱动程序
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
		}catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return conn;
	}
	
	/**
	 * 获取list
	 * @return
	 */
	public List<Map<String,Object>> list(String sql){
		
		Connection conn = getConnection();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		  PreparedStatement pstmt = null;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        ResultSetMetaData  rsmd = rs.getMetaData();
            while(rs.next()){
                Map<String,Object> map = new HashMap<String,Object>();
                for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
                    String col_name = rsmd.getColumnName(i+1);
                    Object col_value = rs.getObject(col_name);
                    map.put(col_name, col_value);
                }
                list.add(map);
            }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally {
	    	if(pstmt != null) {
	    		try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    	}
	    }
	    if(conn != null) {
	    	try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    
	    return list;
	}
	
	public int insert(List<Map<String, String>> list, String dbName) {
		Connection conn = getConnection();
		int i = -1;
		PreparedStatement pstmt;
		try {
			for (Map<String, String> map : list) {
				StringBuilder strKey = new StringBuilder("");
				StringBuilder strValue = new StringBuilder("");
				Set<String> keySet = map.keySet();
				if (keySet.size() == 0)continue;
				if (keySet.size() == 1) {
					strKey.append((String) keySet.toArray()[0]);
					strValue.append("'" + map.get(strKey.toString()) + "'");
				} else {
					ArrayList<String> strKeyList = new ArrayList<>(map.keySet());
					for (int ii = 0; ii < strKeyList.size(); ii++) {
						strKey.append(strKeyList.get(ii));
						strValue.append("'" + map.get(strKeyList.get(ii)) + "'");
						if (ii != strKeyList.size() - 1) {
							strKey.append(",");
							strValue.append(",");
						}
					}
				}
				String sql = "insert into " + dbName + "(" + strKey + ") values(" + strValue + ")";
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				i = pstmt.executeUpdate();
				pstmt.close();
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public void update(String sql) {
		Connection conn = getConnection();

		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	public static void main(String args[]) throws Exception {
 	}
}
