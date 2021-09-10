import java.awt.*;
import javax.swing.*;
class RemoveRows
{ 
  public static void clearRows() 
  {
  	boolean gap=true;
	int numClears = 0;
	for (int j = 21; j > 0; j--) 
	{
	    gap = false;
	    for (int i = 1; i < 11; i++) 
	    {
		if (Va.well[i][j] == Color.BLACK) 
		{
		  gap = true;
		  break;
		}
	    }
	    if (!gap) 
	    {
		deleteRow(j);
		j += 1;
		numClears += 1;
           }
	}
	switch (numClears) 
	{
	    case 1:
		Va.score += Va.scoreins[Va.levelv][0];
		break;
	    case 2:
		Va.score += Va.scoreins[Va.levelv][1];
		break;
	    case 3:
		Va.score += Va.scoreins[Va.levelv][2];
		break;
	    case 4:
		Va.score += Va.scoreins[Va.levelv][3];
		break;
	}
	Va.sp.score.setText(""+Va.score);
  }
  public static void deleteRow(int row) 
  {
     for (int j = row-1; j > 0; j--) 
     {
        for (int i = 1; i < 11; i++) 
	{
	  Va.well[i][j+1] = Va.well[i][j];
        }
     }
  }
}