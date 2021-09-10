import javax.swing.*;
import java.awt.*;
import java.util.*;
class Va
{
  static MainClass game;
  static JButton []bt={new JButton("Start"),new JButton("Pause")};
  static Color[] tetraminoColors = {Color.cyan, Color.blue, Color.orange, Color.yellow, Color.green, Color.pink, Color.red};
  static Color[][] well=new Color[12][24];
  static Random ra=new Random();	
  static int currentPiece,nextPiece;
  static long score;
  static int highscore;
  static Point pieceOrigin;
  static int rotation=0;
  static JLabel hscore=new JLabel();
  static JLabel level=new JLabel("1");		
  static BoardPanel board=new BoardPanel();	
  static ScorePanel sp=new ScorePanel();
  static NextPiecePanel nextp=new NextPiecePanel();
  static boolean started=false,over=false,pausegame=false;
  static int []levelcv={0,1000,2000,3300,4700,6100,7500,9000,11000,13000,16000,20000,25000,35000};
  static int [] timer={800,600,450,350,300,250,220,200,180,165,155,150,146};  
  static int [][] scoreins={{0,0,0,0},{100,300,500,800},{120,320,520,820},{150,350,550,850},{180,380,580,880},{230,430,630,930},{290,490,690,990},{360,560,760,1060},{440,640,840,1140},{530,730,930,1230},{630,830,1030,1330},{740,940,1134,1440},{860,1060,1260,1560},{1000,1300,1600,2000}};  
  static int levelv=1,time=800;
  static Point[][][] tetraminos = 
  {
	// I-Piece
	{
		{ new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0) },
		{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
		{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
		{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
	},
	// J-Piece
	{
		{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
		{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
		{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
		{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
	},
	// L-Piece
	{
		{ new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(2, 1) },
		{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
		{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
		{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
	},
	// O-Piece
	{
		{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
		{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
		{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
		{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
	},
	// S-Piece
	{
		{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
		{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
		{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
		{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
	},
	// T-Piece
	{
		{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
		{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
		{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
		{ new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
	},
	// Z-Piece
	{
		{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
		{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
		{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
		{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
	}
  };
  static void pause(long time)
  {
     try{
	Thread.sleep(time);
     }catch(Exception ex){}	
  }
}