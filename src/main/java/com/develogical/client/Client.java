/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develogical.client;
import com.develogical.ServerManager;
import com.develogical.app.QueryProcessorProxy;
import com.develogical.web.PageFactory;
import com.develogical.web.RegisterPage;
import com.develogical.web.SearchPage;
import com.develogical.web.SheksPage;
import com.develogical.web.SignInPage;
import com.devlogical.database.LegacyMongoDatabase;
import com.devlogical.database.MongoNewAdapter;
import com.devlogical.database.MongoOld;
import com.devlogical.logger.DebugLogger;
import com.devlogical.logger.ErrorLogger;
import com.devlogical.logger.InfoLogger;
import com.devlogical.logger.Logger;
import org.bson.Document;
import org.eclipse.jetty.server.Server;

/**
 *
 * @author ASUS
 */
public class Client {
        public static void main(String[] args) throws Exception {
            ServerManager serverM=ServerManager.getServerManager();
            //singleton design pattern
            Server server=serverM.createServer(9090);
            //factory design pattern
            PageFactory pageF = new PageFactory();
            serverM.registerPage(server, pageF.getSignInPage(), "/login");
            serverM.registerPage(server, pageF.getSignUpPage(), "/register");
            serverM.registerPage(server, pageF.getResultPage(), "/result");
            serverM.registerPage(server, pageF.getSearchPage(), "/search");
            serverM.RegisterRootListener(server, "/sendResult");
            server.start();
            //adapter design pattern
            LegacyMongoDatabase MongoNewAdapter = new MongoNewAdapter();
            MongoNewAdapter.addEntry(new Document("User","ahmed"));
            //proxy design pattern
            QueryProcessorProxy proxy = new QueryProcessorProxy();
            proxy.processQuery("shakespeare");
            //chain of responsiblity design pattern
            Logger logger = new ErrorLogger();
            logger.setNext(new InfoLogger());
            logger.setNext(new DebugLogger());
            logger.logMessage(1, "Error message");  
            logger.logMessage(2, "Info message");  
            logger.logMessage(3, "Debug message");

        }
}