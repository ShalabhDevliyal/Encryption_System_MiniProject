package mini_project_4th_sem;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream; 
public class Cryptography {

	
	public static void operation(int key)
	{
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.showOpenDialog(null);
		File file=fileChooser.getSelectedFile();
		
		//file input stream for input reader
		try 
		{
			FileInputStream fis=new FileInputStream(file);
			
			byte[]data=new byte[fis.available()];
			fis.read(data);
			int i=0;
			for(byte b:data)
			{
				System.out.print(b);
				data[i]=(byte)(b^key);
				i++;
			}
			
			FileOutputStream fos=new FileOutputStream(file);
			fos.write(data);
			fos.close();
			fis.close();
			JOptionPane.showMessageDialog(null, "Done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
			try { 
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
		    } catch(Exception ignored) {}

			System.out.println("Hello This is Image Cryptography model made by Shalabh Devliyal");
			JFrame f=new JFrame();
			
	        
			JLabel label = new JLabel();
			label.setText("THE IMAGE CODER / DECODER");
			label.setFont(new Font("PLAIN",Font.BOLD,25));
			label.setBackground(Color.GREEN);
			label.setOpaque(true);
			
			
			
			JLabel labelB = new JLabel();
			ImageIcon img = new ImageIcon("D:\\Codes\\eclipse workspace\\mini_project_4th_sem\\src\\newicon.gif");
			labelB.setIcon(img);
			
			f.setTitle("Image Cryptography System - By Shalabh Devliyal");
			f.setSize(500, 500);
			f.setLocationRelativeTo(null);
			f.setResizable(false);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Font font=new Font("ROBOTO",Font.BOLD,25);
			
			
			//Creating Button
			JButton button=new JButton();
			button.setText("Encrypt");
			button.setFont(new Font("PLAIN",Font.PLAIN,20));
			
			JButton button1=new JButton();
			button1.setText("Decrypt");
			button1.setFont(new Font("PLAIN",Font.PLAIN,20));
			//Creating text field
			
			JTextField textfield=new JTextField(10);
			textfield.setFont(font);
			textfield.setPreferredSize(new Dimension(250,40));
			textfield.setFont(new Font("PLAIN",Font.PLAIN,35));
			textfield.setBackground(Color.white);
			textfield.setCaretColor(Color.black);
			
			
			//Action Listener
			button.addActionListener(e->
			{
				System.out.println("Button clicked");
				String Text= textfield.getText();
				int temp=Integer.parseInt(Text);
				operation(temp);
				textfield.setText(null);
			});
			button1.addActionListener(e->
			{
				System.out.println("Button clicked");
				String Text= textfield.getText();
				int temp=Integer.parseInt(Text);
				operation(temp);
				textfield.setText(null);
			});
			
			f.setLayout(new FlowLayout());
			f.add(label);
			f.add(button);
			f.add(button1);
			f.add(textfield);
			f.add(labelB);
			f.setVisible(true);
			}

		    	
		   
		}
	
