import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class PlayListener implements ActionListener
{
  JButton bc;
  public void actionPerformed(ActionEvent evt)
  {
    bc=(JButton)evt.getSource();	
    if(bc==Va.bt[0])
   	startTask();
    else if(bc==Va.bt[1])	
        pauseTask();
  }
  private void startTask()
  { 	
    if(bc.getText().equals("Start") && !Va.started)
    {
	Va.bt[1].setEnabled(true);
	Va.over=false;
	bc.setText("NewGame");
	Va.started=true;
	new TetrisThread().start();
    }
    else
     reset();
  }
  void reset()
  {
	Va.sp.fetchScore();
	Va.levelv=1;Va.level.setText("1");
	Va.time=800;
	Va.over=true;
	Va.board.init();
	Va.nextp.comingPiece();
	Va.sp.score.setText("0");
	Va.started=false;
	bc.setText("Start");
	if(Va.score>Va.highscore)
	{
	  Va.sp.setScore();		 
	}
	Va.score=0;
   }
   private void pauseTask()
   { 	
    if(Va.started && bc.getText().equals("Pause"))
    {
	bc.setText("Resume");
	bc.setForeground(Color.blue);
	Va.pausegame=true;
    }	
    else
    {
	synchronized(Va.game)
	{
	    Va.pausegame=false;
	    bc.setText("Pause");
	    bc.setForeground(Color.red);
	    try{
	      Va.game.notify();
	    }catch(Exception ex){}
	}  	
    }	
  }
}
