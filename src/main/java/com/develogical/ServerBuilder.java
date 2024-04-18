/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develogical;

import com.develogical.app.QueryProcessor;
import com.develogical.web.ApiResponse;
import com.develogical.web.IndexPage;
import com.develogical.web.ResultsPage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 *
 * @author ASUS
 */
public class ServerBuilder {
    private Server server = null;
    public ServerBuilder(Server server){
        this.server = server;
    }
    public Server makeWebServer() throws Exception {
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(new ServletHolder(new Website()), "/*");
        handler.addServletWithMapping(new ServletHolder(new Api()), "/api/*");
        server.setHandler(handler);
        return server;
    }

    static class Website extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String query = req.getParameter("q");
            if (query == null) {
                new IndexPage().writeTo(resp);
            } else {
                new ResultsPage(query, new QueryProcessor().process(query)).writeTo(resp);
            }
        }
    }

    static class Api extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String query = req.getParameter("q");
            new ApiResponse(new QueryProcessor().process(query)).writeTo(resp);
        }
    }
}
