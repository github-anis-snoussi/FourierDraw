//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import components.*;
import javax.swing.JTextArea;



public class GuiApp1 {

   
    public GuiApp1() {
     JFrame guiFrame = new JFrame();
     guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     guiFrame.setTitle("FourierDraw");
     guiFrame.setSize(600, 500);
     guiFrame.setLocationRelativeTo(null);


     final FileChooserDemo2 filePanel = new FileChooserDemo2();
     

     final JPanel listPanel = new JPanel();
     listPanel.setVisible(false);
     JLabel listLbl = new JLabel("magic being done...:");
     listPanel.add(listLbl);


     JButton fourierBut = new JButton("DO MAGIC");
     //The ActionListener class is used to handle the
     //event that happens when the user clicks the button.
     //As there is not a lot that needs to happen we can
     //define an anonymous inner class to make the code simpler.
     fourierBut.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
       //When the fruit of veg button is pressed
       //the setVisible value of the listPanel and
       //comboPanel is switched from true to
       //value or vice versa.
        if(filePanel.fileChosen() == true){
            listPanel.setVisible(true);
            filePanel.setVisible(false);
            guiFrame.remove(fourierBut);
        }

      }
     });
     //The JFrame uses the BorderLayout layout manager.
     //Put the two JPanels and JButton in different areas.

        guiFrame.add(filePanel, BorderLayout.NORTH);
        guiFrame.add(listPanel, BorderLayout.CENTER);
        guiFrame.add(fourierBut, BorderLayout.SOUTH);
     


     guiFrame.setVisible(true);
    }
    
   }