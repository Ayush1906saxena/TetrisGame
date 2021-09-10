import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class NextPiecePanel extends JPanel
{
  public NextPiecePanel()
  {
	//setBackground(Color.black);
  }
  public void comingPiece()
  {
	repaint();
  }
  public void paintComponent(Graphics g)
  {
	try{
	  Thread.sleep(10);
        }catch(Exception ex){}
	g.setColor(Color.black);
	g.fillRect(0,0,200,170);
	g.setColor(Color.white);
	g.setFont(new Font("elephant",1,20));
	g.drawString("Next Piece",40,60);
	g.setColor(Color.gray);
	for(int i=0;i<8;i++)
	{
	  g.fillRect(i*25,4,24,24);
	}
	Va.board.nextPiece();
	g.setColor(Va.tetraminoColors[Va.nextPiece]);
	for(Point p:Va.tetraminos[Va.nextPiece][Va.rotation])
	{
	   g.fillRect((p.x+2) * 26,(p.y+3)*26,25, 25);
	}
	g.setColor(Color.gray);
	for(int i=0;i<8;i++)
	{
	  g.fillRect(i*25,145,24,24);
	}
  }
}