package Lab.Unit7;

import java.util.logging.*;
public class LogFile {
    private static  Logger log = Logger.getLogger("request");
    public static void main(String[] args) {
        try {
            log.info( "Line no:"+ new Exception().getStackTrace()[0].getLineNumber());
            System.out.println("Hi");
        }catch (RuntimeException ex){
            log.log(Level.SEVERE, "erro" +ex.getMessage());
        }
    }
}
