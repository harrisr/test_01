import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;

import javax.swing.*;
import java.io.File;

public class MyFrame extends JFrame
{
   private static final Logger logger = LogManager.getLogger(MyFrame.class.getName());
   private MyPanel myPanel;

   public MyFrame()
   {
      String guid = java.util.UUID.randomUUID().toString();
      System.setProperty("log.name", guid.substring(0, 7));
      String fileName = "log4j2.xml";
      LoggerContext context  = (LoggerContext)LogManager.getContext(false);
      context.setConfigLocation(new File(fileName).toURI());

      logger.debug("constructor");
      logger.debug("guid: " + guid);

      myPanel = new MyPanel();
      add(myPanel);
   }
}
