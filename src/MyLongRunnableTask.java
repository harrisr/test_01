import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.config.Configurator;

public class MyLongRunnableTask implements Runnable
{
   private static final Logger logger = LogManager.getLogger(MyFrame.class.getName());

   @Override
   public void run()
   {
      logger.debug("starting new task");

      for (int i=0; i< 400; i++)
      {
         System.out.println("task: incr:" + i);
         logger.debug("task: incr:" + i);
         try
         {
            Thread.sleep(200);
         }
         catch(Exception ex) {};
      }
      logger.debug("finishing new task");
   }
}
