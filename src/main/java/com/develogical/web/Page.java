/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develogical.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public abstract class Page {

    public void writeTo(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writeHeaderTo(writer);
        writeContentTo(writer);
        writeFooterTo(writer);
    }

    private void writeHeaderTo(PrintWriter writer) {
        writer.println("<html>");
        writer.println("<head></head>");
        writer.println("<body>");
    }

    private void writeFooterTo(PrintWriter writer) {
        writer.println("</body>");
        writer.println("</html>");
    }

    protected abstract void writeContentTo(PrintWriter writer);

}

