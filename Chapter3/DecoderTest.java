import java.io.*;
import java.net.*;

public class  DecoderTest{

    public static void main(String[] args) {
        try {
            System.out.println(URLDecoder.decode("This+string+has+spaces", "UTF-8"));
            System.out.println(URLDecoder.decode("This%2Astring%2Ahas%2Aasterisks", "UTF-8"));
            System.out.println(URLDecoder.decode("This%25string%25has%25percent%25signs", "UTF-8"));
            System.out.println(URLDecoder.decode("This%2Bstring%2Bhas%2Bpluses", "UTF-8"));
            System.out.println(URLDecoder.decode("This%2Fstring%2Fhas%2Fslashes", "UTF-8"));
            System.out.println(URLDecoder.decode("This%22string%22has%22quote%22marks", "UTF-8"));
            System.out.println(URLDecoder.decode("This%3Astring%3Ahas%3Acolons", "UTF-8"));
            System.out.println(URLDecoder.decode("This%7Estring%7Ehas%7Etildes", "UTF-8"));
            System.out.println(URLDecoder.decode("This%28string%29has%28parentheses%29", "UTF-8"));
            System.out.println(URLDecoder.decode("This.string.has.periods", "UTF-8"));
            System.out.println(URLDecoder.decode("This%3Dstring%3Dhas%3Dequals%3Dsigns", "UTF-8"));
            System.out.println(URLDecoder.decode("This%26string%26has%26ampersands", "UTF-8"));
            System.out.println(URLDecoder.decode("This%C3%A9string%C3%A9has%C3%A9non%20-ASCII%20characters", "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Broken VM does not support UTF-8");
        }
    }
}
