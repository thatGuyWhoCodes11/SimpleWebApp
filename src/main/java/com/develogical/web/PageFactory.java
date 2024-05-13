/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develogical.web;

/**
 *
 * @author ASUS
 */
public class PageFactory{

    public SignInPage getSignInPage() {
        return new SignInPage();
    }


    public SignInPage getSignUpPage() {
        return new SignInPage();
    }


    public SheksPage getResultPage() {
        return new SheksPage();
    }
    public SearchPage getSearchPage(){
        return new SearchPage();
    }
    
}
