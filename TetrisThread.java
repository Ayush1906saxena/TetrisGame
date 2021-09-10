class TetrisThread extends Thread
{
  public void run()
  {
     while(true)
     {
        try{ 
	  Thread.sleep(Va.time);
	}catch(Exception ex){}
	if(Va.over)
	  break;
	if(Va.pausegame)
	{
	  synchronized(Va.game)
	  {
	    try{
	      Va.game.wait();
	    }catch(Exception ex){}
	  }
	}  
	Va.board.dropDown();
     }	
  }
}