package com.develogical;

import com.develogical.app.QueryProcessor;
import archive.ApiResponse;
import archive.IndexPage;
import archive.ResultsPage;
import com.develogical.web.Page;
import com.develogical.web.SignInPage;
import com.google.gson.Gson;
import java.io.BufferedReader;
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
import org.eclipse.jetty.server.Handler;

public class ServerManager {

    private final static Map<Integer, Server> serverInstances = new HashMap<Integer, Server>();
    private static ServerManager serverManager = null;
    private static ServletHandler handler = null;
    private ServerManager(){}

    public static ServerManager getServerManager() throws Exception {
        if (serverManager == null) {
            return new ServerManager();
        } else {
            return serverManager;
        }
    }

    public Server createServer(int port) {
        if (!serverInstances.containsKey(port)) {
            Server server = new Server(port);
            serverInstances.put(port, server);
            return server;
        } else {
            return serverInstances.get(port);
        }
    }

    public Server registerPage(Server server, Page page, String path) {
        if(server.getHandler() == null){
            this.handler = new ServletHandler();
        }
        else{
            this.handler = (ServletHandler)server.getHandler();
        }
        handler.addServletWithMapping(new ServletHolder(new ServerManager.Website(page)), path);
        server.setHandler(handler);
        return server;
    }
    public Server RegisterRootListener(Server server, String path){
        if(server.getHandler() == null){
            this.handler = new ServletHandler();
        }
        else{
            this.handler = (ServletHandler)server.getHandler();
        }
        handler.addServletWithMapping(new ServletHolder(new ServerManager.Api()), path);
        return server;
    }
    static class Api extends HttpServlet{
        private final Gson gson = new Gson();
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            BufferedReader re = new BufferedReader(req.getReader());
            StringBuilder st = new StringBuilder();
            String line;
            while((line = re.readLine())!=null){
                st.append(line);
            }
            String body = st.toString();
            Map json = gson.fromJson(body, Map.class);
            String search=(String)json.get("search");
            QueryProcessor query = new QueryProcessor();
            String result=query.process(search);
            Map resultHash = new HashMap();
            resultHash.put("result", result);
            String jsonResp = gson.toJson(resultHash);
            resp.setContentType("application/json");
            resp.getWriter().println(jsonResp);
        }
        
    }
    static class Website extends HttpServlet {
        Page page = null;
        public Website(Page page){
            this.page = page;
        }
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            page.writeTo(resp);
        }
    }
}
