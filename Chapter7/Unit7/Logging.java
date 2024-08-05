package Lab.Unit7;
import java.util.logging.*;
public class Logging {
    private static Logger logger = Logger.getLogger("requests");

    public static void main(String[] args) {
           try {
            logger.info("Line No: " + new Exception().getStackTrace()[0].getLineNumber());
            System.out.println("Hi");
            logger.info("Line No throw: " + new Throwable().getStackTrace()[0].getLineNumber());

        } catch (RuntimeException ex) {
            logger.log(Level.SEVERE, "erro" + ex.getMessage(),ex);
        }
    }
}
