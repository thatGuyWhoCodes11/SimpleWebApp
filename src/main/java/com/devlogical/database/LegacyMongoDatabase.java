/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devlogical.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Map;
import org.bson.Document;

/**
 *
 * @author ASUS
 */
public abstract class LegacyMongoDatabase {
    protected MongoCollection setupDatabase(){
        String connection = "mongodb+srv://new_controll111:68199811@cluster0.awwj7t8.mongodb.net/";
        MongoClient mongoClient = MongoClients.create(connection);
        MongoDatabase database=  mongoClient.getDatabase("designPattern");
        MongoCollection collection =database.getCollection("designing");
        return collection;
    }
    public abstract void addEntry(Document entry);
    public abstract void removeEntry(String key, String value);
}