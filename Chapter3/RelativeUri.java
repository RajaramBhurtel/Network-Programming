/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urls.uris;

import java.net.*;


public class RelativeUri {
    public static void main(String[] args) throws URISyntaxException  {
        URI absolute = new URI("http://www.example.com/");
        URI relative = new URI("images/logo.png");
        URI resolved = absolute.resolve(relative);
        
        System.out.println("Base:"+ absolute);
      
        System.out.println("Relative:"+ relative);
        
        System.out.println("resolved:"+resolved);
        
      URI res = absolute.relativize(resolved);
      
       System.out.println("resolved:"+res);
    }
    
}
