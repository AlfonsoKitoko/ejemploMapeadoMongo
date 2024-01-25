package com.amk;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class App {
	public static void main(String[] args) {
		ConnectionString connString = new ConnectionString("mongodb://localhost");
		CodecRegistry pojoCodecRegistry = fromProviders(
				PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry = fromRegistries(
				MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
		MongoClientSettings clientSettings = MongoClientSettings.builder()
				.applyConnectionString(connString)
				.codecRegistry(codecRegistry)
				.build();
		try(MongoClient mongoClient = MongoClients.create(clientSettings);
		){
			MongoDatabase mdb=mongoClient.getDatabase("midb");
			MongoCollection<Disco> mcol=mdb.getCollection("discos",Disco.class);
			//Insertar disco
			//Disco(int id, String titulo, List<String> musicos,String discografica, double precio)
			/*List<String> musicos= Arrays.asList("James Hedfield", "Lars Ulrich");
			Disco d1=new Disco(1,"Master of Puppets",musicos, 20, "RCA");
			mcol.insertOne(d1);*/

			//Insertar múltiples discos
			//No permite crear array estático de discos (Disco[]), hemos de crear un List<Disco>
			/*List<Disco> discos=new ArrayList<>();
			List<String> musicos2=Arrays.asList("Roger Waters","David Gilmour");
			Disco d2=new Disco(2,"The dark side of the moon",musicos2, 30, "RCA");
			Disco d3=new Disco(3,"Kill 'Em All",musicos, 30, "RCA");
			discos.add(d2); discos.add(d3);
			mcol.insertMany(discos);*/

			//Obtener un disco, de id:2
			Disco dc=mcol.find(eq("_id",2)).first();
			System.out.println("El 2ª disco es "+dc);

			//Obtener todos los discos
			FindIterable<Disco> discos2=mcol.find();
			discos2.forEach(System.out::println);
		}
	}
}
