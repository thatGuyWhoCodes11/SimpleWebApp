/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devlogical.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.Map;
import org.bson.Document;

/**
 *
 * @author ASUS
 */
public class MongoOld extends LegacyMongoDatabase{
    MongoCollection collection = null;
    public MongoOld(){
        collection = setupDatabase();
    }
    @Override
    public void addEntry(Document entry){
        collection.insertOne(entry);
    }

    @Override
    public void removeEntry(String key, String value) {
        collection.deleteOne(Filters.eq(key, value));
    }
    
}
