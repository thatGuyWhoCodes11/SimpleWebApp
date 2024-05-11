/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devlogical.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import org.bson.Document;

/**
 *
 * @author ASUS
 */
public class MongoNew {
    MongoCollection collection = null;
    public MongoNew(MongoCollection collection){
        this.collection = collection;
    }
    void updateEntry(String key, String value){
        collection.findOneAndUpdate(Filters.eq(key, value),new Document("$set",new Document().append(key, value)),new FindOneAndUpdateOptions().upsert(true));
    }
    public void removeEntry(String key, String value) {
        collection.deleteOne(Filters.eq(key, value));
    }
}