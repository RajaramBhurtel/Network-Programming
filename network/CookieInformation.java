/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;
import java.net.*;
import java.util.List;


/**
 *
 * @author Dell
 */
public class CookieInformation {
    private final static String URL_STRING = "http://www.bing.com";
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException  {
       
        CookieManager cookieManager = new CookieManager();
  
      CookieHandler.setDefault(cookieManager);
  
      URL url = new URL(URL_STRING);
  
      URLConnection connection = url.openConnection();
      connection.getContent();
  
      CookieStore cookieStore = cookieManager.getCookieStore();
  
      List<HttpCookie> cookieList = cookieStore.getCookies();
  
      //iterate HttpCookie object
  
      for (HttpCookie cookie : cookieList) 
      {
          System.out.println("");
         //gets domain set for the cookie
         System.out.println("Domain: "+cookie.getDomain());
  
         //gets max age of the cookie
         System.out.println("max age: "+cookie.getMaxAge());
  
         // gets name cookie
         System.out.println("name of cookie: "+cookie.getName());
  
         //gets path of the server
         System.out.println("server path: "+cookie.getPath());
  
         //gets boolean if cookie is being sent with secure protocol
         System.out.println("is cookie secure: "+cookie.getSecure());
  
         //gets the value of the cookie
         System.out.println("value of cookie: "+cookie.getValue());
  
        //gets the version of the protocol with which the given cookie is related.
        System.out.println("value of cookie: "+cookie.getVersion());
      }
   }
}
    
    

