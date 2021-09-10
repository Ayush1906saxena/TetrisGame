import javax.swing.*;
import java.awt.*;
import java.util.*;
class BoardPanel extends JPanel
{
 
  private ArrayList<Integer> nextPieces = new ArrayList<Integer>();	
  public void init()
  {
    for(int i=0;i<12;i++)
    {
	for(int j=0;j<23;j++)
	{
	   Va.well[i][j]=Color.black;
	   if(i==0 || i==11 || j==22)
	     Va.well[i][j]=Color.gray;	    
	}
    }
    repaint();	
    newPiece();	
  }
  private void newPiece()
  {
	Va.rotation=0;
	Va.pieceOrigin=new Point(5,0);
	if(Va.started)
	  Va.currentPiece=Va.nextPiece;
	else
	{
	  if(nextPieces.isEmpty()) 
	  {
	    Collections.addAll(nextPieces, 0, 1, 2, 3, 4, 5, 6);
	    Collections.shuffle(nextPieces);
	  }
	  Va.currentPiece = nextPieces.get(0);
	  nextPieces.remove(0);
	}
  }
  void nextPiece()
  {
	if(nextPieces.isEmpty()) 
	{
	  Collections.addAll(nextPieces, 0, 1, 2, 3, 4, 5, 6);
	  Collections.shuffle(nextPieces);
	}
	Va.nextPiece = nextPieces.get(0);
	nextPieces.remove(0);
  }
  public void drawPiece(Graphics g)
  {
       	 g.setColor(Va.tetraminoColors[Va.currentPiece]);
	 for(Point p:Va.tetraminos[Va.currentPiece][Va.rotation])
	 {
	   g.fillRect((p.x + Va.pieceOrigin.x) * 26,(p.y+Va.pieceOrigin.y) * 26,25, 25);
	 }
  }
  public boolean collidesAt(int x, int y, int rotation)
  {
    for (Point p : Va.tetraminos[Va.currentPiece][rotation]) 
    {
      if(Va.well[p.x + x][p.y + y] != Color.BLACK) 
 	return true;
    }
    return false;
  } 
  public void dropDown()
  {
	if(!collidesAt(Va.pieceOrigin.x, Va.pieceOrigin.y + 1, Va.rotation)) 
	{
	    Va.pieceOrigin.y += 1;
	}
	else
	{
	    fixToWell();
	}	
	repaint();
  }
  public void fixToWell()
  {
     for(Point p:Va.tetraminos[Va.currentPiece][Va.rotation]) 
     {
	Va.well[Va.pieceOrigin.x + p.x][Va.pieceOrigin.y + p.y] = Va.tetraminoColors[Va.currentPiece];
     }
     RemoveRows.clearRows();
     if(Va.pieceOrigin.y==0)
     {
	if(Va.score>Va.highscore)
	{
	  Va.sp.setScore();		 
	}
	Va.over=true;
	Va.started=false;
	JOptionPane.showMessageDialog(Va.game,"OOPS ! ! ! ! Game over....");
	return;
     }	
     newPiece();
     Va.nextp.comingPiece();	
  }
 
  public void move(int i)
  {
	if(!collidesAt(Va.pieceOrigin.x + i, Va.pieceOrigin.y, Va.rotation)) 
	{
	    Va.pieceOrigin.x += i;	
	}
	repaint();
  }
  public void rotate(int i)
  {
	int newRotation = (Va.rotation + i) % 4;
	if(newRotation<0) 
	  newRotation = 3;
	if(!collidesAt(Va.pieceOrigin.x, Va.pieceOrigin.y,newRotation)) 
	  Va.rotation = newRotation;
	repaint();
  }
  public void paintComponent(Graphics g)
  {
	g.fillRect(0,0,26*12,26*23);
	for(int i=0;i<12;i++)
    	{
	  for(int j=0;j<23;j++)
	  {
	     g.setColor(Va.well[i][j]);
	     g.fillRect(26*i,26*j,25,25);
	  }
        }
	drawPiece(g);
	if(Va.score>Va.highscore)
	{
	  Va.sp.setScore();		 
	}
	if(Va.score>=Va.levelcv[Va.levelv])
	{
	  Va.time=Va.timer[Va.levelv];
	  Va.levelv++;
	  Va.level.setText(""+Va.levelv);
	} 	
  }
}