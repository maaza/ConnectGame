/**
 * 
 */
package edu.nyu.pqs.connect4.playerfactory;
import edu.nyu.pqs.connect4.connectgame.ConnectGame;

/**
 * ConnectPlay implements to the IConnectPlayer method
 * @author malathidharmalingam
 * Version 1.0
 */
public class ConnectPlay implements IConnectPlayer{
	
	 private ConnectGame connectgameobj;
	 private ConnectPlayer type;
	 private int playerNumber;
	 
	 /* ConnectPlay constructor Method for the connectgame object
	  */
	  public ConnectPlay(ConnectGame connectgameobj,int playerNumber,int type){
	    this.connectgameobj=connectgameobj;
	    this.playerNumber=playerNumber;
	    if(type==0)
	    {
	    this.type=ConnectPlayer.Human;
	    }
	    else
	    {
	     this.type = ConnectPlayer.Computer;
	    }
	  }
	  /**
	   * Returns the player type as human
	   */
	  @Override
	  public ConnectPlayer getPlayerType() {
	    return type;
	  }
 
	 /**
	 * Returns the number of the player in the game
	 */
	  @Override
	  public int getPlayerNumber() {
	   return playerNumber;
	  }
	  /**
	   * Sets the next move taken by the player
	   */
	  @Override
	  public void setNextMove(int column,int type) {
		 if(this.type == ConnectPlayer.Human){
				connectgameobj.setMove(column,0,1);  
		 }
		 else
		 {
			 if(!NextMoveComputer())
			 {
				 if(!NextMoveAggresive())
				 {
				 connectgameobj.setMove(column,1,0);   
				 }
  
			 }
	    }
	 }
	  
	  /* In This Method the Computer checks if it can block 
	   * slots of the  Human , When Human is going to Win
	   */
	  public boolean NextMoveAggresive(){
		    connectgameobj.setCurrentPlayer(0);
		    for(int i=connectgameobj.getRows()-1;i>=0;i--){
			      for(int j=0;j<connectgameobj.getColumns();j++){
			        if(connectgameobj.getBoardSlot(i,j)==-1){
			        	if(i==connectgameobj.getRows()-1){
			        		connectgameobj.MoveTemp(i,j);
			        	}
			        	else if(connectgameobj.getBoardSlot(i+1,j)!=-1){
			        		connectgameobj.MoveTemp(i,j);
			        	}
			          if(connectgameobj.hasWon()){	 
			        	connectgameobj.setCurrentPlayer(1);
			        	connectgameobj.resetMove(i,j);
			        	connectgameobj.MoveTemp(i,j);
			            connectgameobj.setMove(i,j);
			            return true;
			          }
			          else{
			            connectgameobj.resetMove(i,j);
			          }
			        }
			      }
			    }
		    	connectgameobj.setCurrentPlayer(1);
			    return false;
		  }
	  
	  
	  /* This Method checks if the computer can make 
	   * a winning move, If not it return a 
	   * boolean value of false
	   */
	  public boolean NextMoveComputer(){	   
		    for(int i=connectgameobj.getRows()-1;i>=0;i--){
		      for(int j=0;j<connectgameobj.getColumns();j++){
		        if(connectgameobj.getBoardSlot(i,j)==-1){
		        	if(i==connectgameobj.getRows()-1){
		        		connectgameobj.MoveTemp(i,j);
		        	}
		        	else if(connectgameobj.getBoardSlot(i+1,j)!=-1){
		        		connectgameobj.MoveTemp(i,j);
		        	}
		          if(connectgameobj.hasWon()){
		        	  
		        	System.out.println("I won" );
		            connectgameobj.setMove(i,j);
		            return true;
		          }
		          else{
		            connectgameobj.resetMove(i,j);
		          }
		        }
		      }
		    }
		    return false;
	  }
}
