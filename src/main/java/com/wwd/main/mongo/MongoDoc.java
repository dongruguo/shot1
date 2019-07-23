package com.wwd.main.mongo;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDoc {
	
	public static void main(String[] args) {
		 MongoClient mongoClient = new MongoClient( "192.168.1.104" , 27017 );
		 MongoDatabase database = mongoClient.getDatabase("test");
		  MongoCollection<Document> docs =  database.getCollection("user");
		  Document doc = new Document().append("userName", "王国飞").append("wife","美女");
	//	  docs.insertOne(doc);
		  BasicDBObject object = new BasicDBObject().append("userName", "王国飞");
		  FindIterable<Document> tds = docs.find(object);
		  MongoCursor<Document> mongoCursor = tds.iterator();
		  while(mongoCursor.hasNext()) {
			  System.out.println(mongoCursor.next());
		  }
	}

}
