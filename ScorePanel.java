import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
class ScorePanel extends JPanel
{
  JLabel score=new JLabel("0");
  Font fo=new Font("elephant",0,19);
  public ScorePanel()
  {
	setBackground(Color.black);
	setLayout(new GridLayout(3,2,10,0));
	add(new JLabel("<html><h2 style='color:blue;font-family:elephant'>SCORE:</h2></html>"));
	score.setFont(fo);
	score.setForeground(Color.white);
	add(score);
	add(new JLabel("<html><h2 style='color:red;font-family:elephant'>LEVEL:</h2></html>"));
	Va.level.setForeground(Color.white);
	Va.level.setFont(fo);
	add(Va.level);
	add(new JLabel("<html><h3 style='color:yellow;font-family:elephant'>HIGHEST:</h3></html>"));
	Va.hscore.setFont(fo);
	Va.hscore.setForeground(Color.white);
	add(Va.hscore);
  }
  void fetchScore()
  {
	try{
	   BufferedReader br=new BufferedReader(new FileReader(System.getProperty("user.home")+"/score.dat"));	  
	   Va.highscore=Integer.parseInt(br.readLine());
	   Va.hscore.setText(""+Va.highscore);
	}catch(Exception ex){System.out.println("1:"+ex);}
  }
  void setScore()
  {
	try{
	     PrintWriter pw=new PrintWriter(new FileWriter(System.getProperty("user.home")+"/score.dat"));	  
	     pw.println(Va.score);
	     pw.close();
	}catch(Exception ex){System.out.println("2"+ex);}
  }
  void createScoreFile()
  {
   try{
     File file=new File(System.getProperty("user.home")+"/score.dat");
     if(file.createNewFile())
     { 	
       PrintWriter pw=new PrintWriter(new FileWriter(file));	  
       pw.println(0);
       pw.close();
     }
   }catch(Exception ex){System.out.println("2"+ex);}
 }
}