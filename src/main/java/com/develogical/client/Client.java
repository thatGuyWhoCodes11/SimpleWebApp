/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develogical.client;

import com.develogical.ServerManager;
import com.develogical.web.RegisterPage;
import com.develogical.web.SignInPage;
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
            server.start();
    }
}
