import javax.swing.*;
import components.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;


public class GuiApp1 extends JPanel{

    private File imageFile ;
   
    public GuiApp1() {
     
     JFrame guiFrame = new JFrame();
     guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     guiFrame.setTitle("FourierDraw");
     guiFrame.setSize(600, 500);
     guiFrame.setLocationRelativeTo(null);
     

     final JPanel listPanel = new JPanel();
     listPanel.setVisible(false);
     JLabel listLbl = new JLabel("magic being done...:");
     listPanel.add(listLbl);

     final JPanel welcome = new JPanel();
     welcome.setVisible(true);
     JLabel welcomeText = new JLabel("you wanna do magic?");
     welcome.add(welcomeText);


     JButton fourierBut = new JButton("DO MAGIC");
     fourierBut.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
            JFileChooser fc = new JFileChooser();
            System.out.println("you clicked !!!!");
            fc.addChoosableFileFilter(new ImageFilter());
            fc.setAcceptAllFileFilterUsed(false);
            fc.setFileView(new ImageFileView());
            fc.setAccessory(new ImagePreview(fc));

        int returnVal = fc.showDialog(GuiApp1.this,"Attach");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("YAY! you made a choice ");
            imageFile = fc.getSelectedFile();
            listPanel.setVisible(true);
            welcome.setVisible(false);
            guiFrame.remove(fourierBut);

        }else{
            System.out.println("you didn't chose a file bruh..");
        }
        fc = null ;
        System.gc();
      }
     });

        guiFrame.add(welcome, BorderLayout.NORTH);
        guiFrame.add(listPanel, BorderLayout.CENTER);
        guiFrame.add(fourierBut, BorderLayout.SOUTH);
     


     guiFrame.setVisible(true);
    }
    
   }