//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import components.*;



public class GuiApp1 {

   
    public GuiApp1() {
     JFrame guiFrame = new JFrame();
     guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     guiFrame.setTitle("FourierDraw");
     guiFrame.setSize(600, 500);
     guiFrame.setLocationRelativeTo(null);


     final JPanel comboPanel = new JPanel();
     JFileChooser test = new JFileChooser();
     comboPanel.add(test);

     
     final JPanel listPanel = new JPanel();
     listPanel.setVisible(false);
     JLabel listLbl = new JLabel("magic being done...:");
     listPanel.add(listLbl);


     JButton vegFruitBut = new JButton("DO MAGIC");
     //The ActionListener class is used to handle the
     //event that happens when the user clicks the button.
     //As there is not a lot that needs to happen we can
     //define an anonymous inner class to make the code simpler.
     vegFruitBut.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
       //When the fruit of veg button is pressed
       //the setVisible value of the listPanel and
       //comboPanel is switched from true to
       //value or vice versa.
       listPanel.setVisible(!listPanel.isVisible());
       comboPanel.setVisible(!comboPanel.isVisible());
      }
     });
     //The JFrame uses the BorderLayout layout manager.
     //Put the two JPanels and JButton in different areas.
     guiFrame.add(comboPanel, BorderLayout.NORTH);
     guiFrame.add(listPanel, BorderLayout.CENTER);
     guiFrame.add(vegFruitBut, BorderLayout.SOUTH);


     
     guiFrame.setVisible(true);
    }
    
   }