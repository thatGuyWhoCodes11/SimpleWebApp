/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develogical.client;

import com.develogical.ServerManager;
import com.develogical.app.QueryProcessorProxy;
import com.develogical.web.RegisterPage;
import com.develogical.web.SearchPage;
import com.develogical.web.SheksPage;
import com.develogical.web.SignInPage;
import com.devlogical.database.LegacyMongoDatabase;
import com.devlogical.database.MongoNewAdapter;
import com.devlogical.database.MongoOld;
import org.bson.Document;
import org.eclipse.jetty.server.Server;

/**
 *
 * @author ASUS
 */
public class Client {
        public static void main(String[] args) throws Exception {
            ServerManager serverM=ServerManager.getServerManager();
            Server server=serverM.createServer(9090);
            serverM.registerPage(server, new SignInPage(), "/login");
            serverM.registerPage(server, new RegisterPage(), "/register");
            serverM.registerPage(server, new SheksPage(), "/result");
            serverM.registerPage(server, new SearchPage(), "/search");
            serverM.RegisterRootListener(server, "/sendResult");
            server.start();
            LegacyMongoDatabase MongoNewAdapter = new MongoNewAdapter();
            MongoNewAdapter.addEntry(new Document("User","ahmed"));

            QueryProcessorProxy proxy = new QueryProcessorProxy();
proxy.processQuery("shakespeare");
        }
}