/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develogical.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class SearchPage extends Page {

    @Override
    protected void writeContentTo(PrintWriter writer) {
        try {
            writer.println(fileReader());
        } catch (IOException ex) {
            Logger.getLogger(SignInPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String fileReader() throws IOException{
        StringBuilder content = new StringBuilder();
        String file = new File(
            "src\\main\\java\\html stuff\\searchPage.html").getAbsolutePath();
        BufferedReader br
            = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
            content.append(st);
        System.out.println(content);
        return content.toString();
    }
}
