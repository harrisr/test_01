import javax.swing.*;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import java.io.File;

public class Main
{
   private static final Logger logger = LogManager.getLogger(Main.class.getName());

   public static void main(String[] args)
   {
      String guid = java.util.UUID.randomUUID().toString();
      System.setProperty("log.name", guid.substring(0, 7));
      String fileName = "log4j2.xml";
      LoggerContext context  = (LoggerContext)LogManager.getContext(false);
      context.setConfigLocation(new File(fileName).toURI());

      logger.debug(".......   Main  ..........");
      logger.debug("guid: " + guid);

      MyFrame frm = new MyFrame();
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frm.setSize(600, 400);
      frm.setVisible(true);
      logger.debug(".......   hello world  ..........");
   }
}
