import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;

public class MyPanel extends JPanel implements ActionListener
{
   private static final Logger logger = LogManager.getLogger(MyFrame.class.getName());
   private JButton btnFrame;
   private JButton btnThread;

   public MyPanel()
   {
      String guid = java.util.UUID.randomUUID().toString();
      System.setProperty("log.name", guid.substring(0, 7));
      String fileName = "log4j2.xml";
      LoggerContext context  = (LoggerContext)LogManager.getContext(false);
      context.setConfigLocation(new File(fileName).toURI());


      logger.debug("constructor");
      btnFrame = new JButton("Create New Frame");
      btnFrame.setActionCommand("frame");
      btnFrame.addActionListener(this);
      add(btnFrame);

      btnThread = new JButton("Create New Thread");
      btnThread.setActionCommand("thread");
      btnThread.addActionListener(this);
      add(btnThread);
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (e.getActionCommand().toLowerCase().equals("frame"))
      {
         logger.debug("about to create a new frame");

         System.out.println("about to create a new frame");
         MyFrame frm = new MyFrame();
         frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frm.setSize(600, 400);
         frm.setVisible(true);
      }
      else
      {
         logger.debug("about to create a new thread");

         System.out.println("about to create a new thread");
         Thread task = new Thread(new MyLongRunnableTask());
         task.start();
      }
   }
}
