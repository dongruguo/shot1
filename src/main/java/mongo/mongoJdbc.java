package mongo;

import java.lang.reflect.InvocationTargetException;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class mongoJdbc {
	
	MongoClient mongoClient = new MongoClient( "192.168.1.104" , 27017 );
	  DB db = mongoClient.getDB("test");
      DBCollection  col =    db.getCollection("user");
	
	@Test
	public  void jsonInsert() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		String insertstr = "{'userName':'天下第一','wife':'天下无敌'}";
		DBObject insertObj = (DBObject)JSON.parse(insertstr);
		col.insert(insertObj);
		User user = new User();
		BeanUtils.dbObjectToBean(insertObj, user);
		System.out.println(user.getUserName());
		
	}
	
	@Test
	public  void remove() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		col.remove(new BasicDBObject("_id",new ObjectId("5ce9576f391a3a7edc31e441")));
	}
	
	@Test
	public void updateUserSet() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		BasicDBObject obj = new BasicDBObject();
		BasicDBObject obj2 = new BasicDBObject().append("son","桂浩然");
		obj.put("$set", obj2);
		col.update( new BasicDBObject().append("userName", "王卫东"), obj);
		DBObject resultObj = col.findOne( new BasicDBObject().append("userName", "王卫东"));
		User user = new User();
		BeanUtils.dbObjectToBean(resultObj, user);
		System.out.println(user.getSon());
	}
	
	public static void main(String[] args) {
		 MongoClient mongoClient = new MongoClient( "192.168.1.104" , 27017 );
	       
         // 连接到数据库
         DB db = mongoClient.getDB("test");
         db.getCollection("user");
         DBCollection  col =    db.getCollection("user");
      /*   DBObject query = new BasicDBObject();
         query.put("userName", "wwd");
         col.remove(query);*/
    //     BasicDBObject obj = new BasicDBObject();
         
       //  obj.append("userName", "王卫东").append("wife", "程娟").append("email",new String[] {"qqq","ddddd"});
    //     col.insert(obj);
         BasicDBObject  resultQuery = new BasicDBObject();
         DBCursor result  = col.find(resultQuery ,new BasicDBObject().append("userName", 2).append("_id", 0)).sort(new BasicDBObject("userName",-1));
         while(result.hasNext()) {
        	 DBObject resultObj = result.next();
        	 System.out.println(resultObj);
         }
	}

}
