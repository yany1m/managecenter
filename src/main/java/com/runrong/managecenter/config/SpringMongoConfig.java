package com.runrong.managecenter.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.Mongo;

@Configuration  
public class SpringMongoConfig {
	
	 	
     public static String url;
 	 public static String collection;
	    
	
	 public static void init() throws Throwable {
	        InputStream in;
	        File file = new File("./config/mongodb.properties");
	        if(file.exists()){

	            in = new FileInputStream(file);
	        }else {
	            in = SpringMongoConfig.class.getClassLoader().getResourceAsStream("config/mongodb.properties");
	        }

	        Properties properties = new Properties();
	        properties.load(in);
	        in.close();


	        url = properties.getProperty("url");
	        collection = properties.getProperty("collection");
	       
	    }
	    
	
	  public @Bean  
	  MongoDbFactory mongoDbFactory() throws Exception {  
	    return new SimpleMongoDbFactory(new Mongo(url), collection);  
	  }  
	   
	  public @Bean  
	  MongoTemplate mongoTemplate() throws Exception {  
	   
	    //remove _class  
	    MappingMongoConverter converter =   
	        new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());  
	    converter.setTypeMapper(new DefaultMongoTypeMapper(null));  
	   
	    MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);  
	   
	    return mongoTemplate;  
	   
	  }  
	  
}
