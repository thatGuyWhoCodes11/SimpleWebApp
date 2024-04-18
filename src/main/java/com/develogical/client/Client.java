/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develogical.client;

import com.develogical.ServerBuilder;
import com.develogical.ServerManager;
import org.eclipse.jetty.server.Server;

/**
 *
 * @author ASUS
 */
public class Client {
        public static void main(String[] args) throws Exception {
            ServerManager serverM=ServerManager.getServerManager();
            Server server=serverM.createServer(9090);
            ServerBuilder serverB=new ServerBuilder(server);
            Server webServer=serverB.makeWebServer();
            webServer.start();
    }
}
