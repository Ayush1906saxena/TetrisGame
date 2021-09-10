import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class MainClass extends JFrame
{
  public MainClass()
  {
	super("Tetris puzzle");
	Va.game=this;
	setSize(26*12+210,26*23+25);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setLayout(null);
	Va.sp.createScoreFile();
	Va.sp.fetchScore();
	Va.board.init();
	Va.board.setBounds(0,0,26*12,26*23);
	add(Va.board);
	Va.sp.setBounds(26*12,0,200,130);
	add(Va.sp);
	Va.nextp.setBounds(26*12,130,200,170);
	add(Va.nextp);
        InstructionPanel insp=new  InstructionPanel();
	insp.setBounds(26*12,300,200,290);
	add(insp);
	setVisible(true);
	
  }
  public static void main(String []args)
  {
	new MainClass();
  }
}