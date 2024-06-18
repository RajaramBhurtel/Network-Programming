import java.net.*;  
public class URL1{  
    public static void main(String[] args){  
        try{  
            URL url=new URL("http://www.eiccollege.edu.np");  
  
            System.out.println("url : "+url); 
            
        }catch(Exception e){
            System.out.println(e);
        }  
    }  
}  