/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devlogical.database;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author ASUS
 */
public class MongoNewAdapter extends LegacyMongoDatabase{
    MongoCollection collection= null;
    MongoNew mong = null;
    public MongoNewAdapter(){
        collection=setupDatabase();
        mong=new MongoNew(collection);
        this.collection = setupDatabase();
    }
    @Override
    public void addEntry(Document entry) {
        for(String key : entry.keySet()){
            mong.updateEntry(key, entry.get(key).toString());
        }
    }

    @Override
    public void removeEntry(String key, String value) {
        mong.removeEntry(key, value);
    }
}
