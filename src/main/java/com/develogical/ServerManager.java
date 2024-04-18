package com.develogical;

import com.develogical.app.QueryProcessor;
import com.develogical.web.ApiResponse;
import com.develogical.web.IndexPage;
import com.develogical.web.ResultsPage;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class ServerManager {
    private static Map<Integer,Server> serverInstances = new HashMap<Integer,Server>();
    private static ServerManager serverManager = null;
    private ServerManager() throws Exception {}
    public static ServerManager getServerManager() throws Exception{
        if(serverManager == null){
            return new ServerManager();
        }
        else{
            return serverManager;
        }
    }
    public Server createServer(int port){
        if(!serverInstances.containsKey(port)){
            Server server = new Server(port);
            serverInstances.put(port, server);
            return server;
        }
        else{
            return serverInstances.get(port);
        }
    }
}

