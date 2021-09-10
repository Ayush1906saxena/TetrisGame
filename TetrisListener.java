import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class TetrisListener extends KeyAdapter
{
  public void keyPressed(KeyEvent evt)
  {
     int kc=evt.getKeyCode();
     if(kc==KeyEvent.VK_ESCAPE)	
     {	
	int op=JOptionPane.showConfirmDialog(Va.game,"Do you want to quit?"); 	
	if(op==JOptionPane.YES_OPTION)
	{
	  if(Va.score>Va.highscore)
	  {
	    Va.sp.setScore();		 
	  }
	  System.exit(0);	    
	}
     } 	
     if(!Va.started || Va.over || Va.pausegame)
	return;
     if(kc==KeyEvent.VK_DOWN)
        Va.board.dropDown();
     else if(kc==KeyEvent.VK_UP)
	Va.board.rotate(-1);
     else if(kc==KeyEvent.VK_LEFT)	 	
	Va.board.move(-1);
     else if(kc==KeyEvent.VK_RIGHT)	 	
	Va.board.move(1);
  }
}
