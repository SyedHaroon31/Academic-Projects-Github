/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/**
 *
 * @author haroonperveez
 */
public class Validator {
    public static String generateHash(String password) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(password.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (byte a :hashedBytes) 
                        {
				byte b = a;
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}
    
     public static void onlyString(KeyEvent evt, JTextField field) {
          char c = evt.getKeyChar();
        if (!((c >= 'A') && (c <= 'Z') || (c >= 'a') && (c <= 'z') || (c==evt.VK_SPACE) || (c==evt.VK_CAPS_LOCK) || (c==evt.VK_SHIFT)||
            (c == evt.VK_BACK_SPACE) ||
            (c == evt.VK_DELETE))) {

        JOptionPane.showMessageDialog(null, "Enter Alphabets only");
       field.setText("");
        }
     }
     public static void onlyInteger(KeyEvent evt, JTextField field) {
          char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')||
            (c == evt.VK_BACK_SPACE) ||
            (c == evt.VK_DELETE))) {

        JOptionPane.showMessageDialog(null, "Enter Integers only");
       field.setText("");
        }
     }
    public ImageIcon ResizeImage(String ImagePath,JLabel imageLabel)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    private static void FormatTool(Component c,int action)
    {
        Color whiteColor=Color.decode("#FFFFFF");
        Color blackColor=Color.decode("#000000");
        if(c!=null)
        {
            if(c instanceof JButton)
            {
                Color btnColor=Color.decode("#D64541");
                c.setForeground(whiteColor);
                c.setBackground(btnColor);
            }
            else if(c instanceof JLabel)
            {
                c.setForeground(whiteColor);
            }
        }
    }
    
    public static void FormatPanel(JPanel panel,int action)
    {
        if(action==0)
        {
            if(panel.getComponents()[0] instanceof JSplitPane)
            {
                panel=((JPanel)((JSplitPane)(panel.getComponents()[0])).getRightComponent());  
                //panel.setBackground(Color.decode("#2c3e50"));  44,62,80
            }            
        }
        Component[] componentArray = panel.getComponents();
        for(Component c: componentArray)
        {
            if(c instanceof JLabel && action==0)
            {
                utility.Validator.FormatTool(c,0);
            }
            else if(c instanceof JPanel && action==0)
            {                
                utility.Validator.FormatPanel(((JPanel)c),1);
            }        
            else if(c instanceof JButton)
            {
                utility.Validator.FormatTool(c,0);
            }
        }

    }
   public static void generateCsvFile(ArrayList<String> writeData,int flag)
    {
        if(flag==1)
        {
           try
           {
               File file =   new File("in.csv");
           
               if (!file.exists()){
                     file.createNewFile();
                }
               FileWriter writer = new FileWriter(file);

                writer.append("Glucose");
                writer.append(',');
                writer.append("BP");
                writer.append(',');
                writer.append("Insulin");
                writer.append(',');
                writer.append("BMI");                
                writer.append(',');
                writer.append("Age");
                writer.append('\n');                
                int i=0;
                for (String s: writeData) {
                     writer.append(writeData.get(i));
                     if(i<4)
                     {
                        writer.append(',');
                     }
                     i++;
                }
                writer.append('\n');
                
                writer.flush();
                writer.close();
           } catch(IOException e) {
                 e.printStackTrace();
           }
        }
      }
   
   
   public static String ValidateTextFields(JTextField txt,boolean checkRequired,int onlyDigitsOrDate,int minlength,int maxlength)
    {
        if(checkRequired)
        {
            if((txt.getText()).equals(""))
            {
                txt.requestFocusInWindow();
                return "Please fill a value in "+txt.getName();
            }
        }
        if(minlength != 0)
        {
            if((txt.getText()).length() < minlength)
            {
                txt.requestFocusInWindow();
                return "Your input in "+txt.getName()+" has to be atleast "+minlength+ " characters long!";
            }
        }
        if(maxlength != 0)
        {
            if((txt.getText()).length() > maxlength)
            {
                txt.requestFocusInWindow();
                return "Your input in "+txt.getName()+" cannot exceed "+maxlength+ " characters !";
            }
        }
        if(onlyDigitsOrDate == 0)//check String
        {
            if(!(txt.getText()).matches("[A-Za-z.\\s]+"))
            {
                txt.requestFocusInWindow();
                return "Please fill only alphabets value in " + txt.getName();

            }
        }
        if(onlyDigitsOrDate == 1)//check Float
        {
            if(!(txt.getText()).matches("(?:[1-9]\\d*|0)?(?:\\.\\d+)?"))
            {
                txt.requestFocusInWindow();
                return "Please fill only digits/decimal value in " + txt.getName();
            }
        }
        if(onlyDigitsOrDate == 3)//check Int
        {
            if(!(txt.getText()).matches("[0-9]\\d*"))
            {
                txt.requestFocusInWindow();
                return "Please fill only digits in " + txt.getName();
            }
        }
        if(onlyDigitsOrDate == 2)//check Date
        {
           if(txt.getText().length() == 10)
           {
                String date = txt.getText();
                String MM=date.substring(0,2);
                String DD=date.substring(3,5);
                String YYYY=date.substring(6);
                if(date.substring(2,3).equals("/") && date.substring(5,6).equals("/"))
                {
                     if(MM.matches("[0-9]\\d*") && DD.matches("[0-9]\\d*") && YYYY.matches("[0-9]\\d*"))
                     {
                         if(!(Integer.parseInt(MM)>0 && Integer.parseInt(MM)<13))
                         {
                             txt.requestFocusInWindow();  
                             return "Please enter date in a valid MM/DD/YYYY format!";
                         }
                         if(!(Integer.parseInt(DD)>0 && Integer.parseInt(DD)<32))
                         {
                             txt.requestFocusInWindow();  
                             return "Please enter date in a valid MM/DD/YYYY format!";
                         }
                         if(!(Integer.parseInt(YYYY)>1900 && Integer.parseInt(YYYY) <= Calendar.getInstance().get(Calendar.YEAR)+10))
                         {
                             txt.requestFocusInWindow();  
                             return "Please enter date in a valid MM/DD/YYYY format!";
                         }
                     }
                     else
                     {
                        txt.requestFocusInWindow();  
                        return "Please enter date in a valid MM/DD/YYYY format!";  
                     }
                }
                else
                {
                    txt.requestFocusInWindow();  
                    return "Please enter date in a valid MM/DD/YYYY format!";  
                }
           }
           else
           {
               txt.requestFocusInWindow();  
               return "Please enter date in a valid MM/DD/YYYY format!";  
           }
        }
        return "";
    }
}
