package edu.nyu.pqs.connect4.playerfactory;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
 
 
import edu.nyu.pqs.connect4.connectgame.ConnectGame;
 
/**
 * @author malathidharmalingam
 * Version 1.0;
 * This class represents a factory for creating players. It is a singleton class
 */

public class  ConnectPlayerFactory {
	 
	 private static ConnectPlayerFactory ConnectPlayerFactory;
	 //Generates the ids of the Players
	  private static Map<ConnectGame,Integer> idplayer; 
	  
	  private ConnectPlayerFactory(){}
	  
	  /**
	   * This is method get the singleton player factory object
	   * @return
	   */
	  public static ConnectPlayerFactory getConnectPlayerFactory(){
		  	if(ConnectPlayerFactory==null){
		  		ConnectPlayerFactory=new ConnectPlayerFactory();
		  		idplayer=new HashMap<ConnectGame,Integer>();
		  	}
		  	return ConnectPlayerFactory;
		  }
	  
	  /**
	   * This method is used to create a player of the specified type
	   */
	  public IConnectPlayer createPlayer(ConnectPlayer type,ConnectGame connectFourGame){
		    int id=0;
		  	if(idplayer.get(connectFourGame)==null){
		  		id=0;
		  	}
		  	else{
		  		id=idplayer.get(connectFourGame);
		  		id++;
		  	}
		  	idplayer.put(connectFourGame,id);
		  	if(type==ConnectPlayer.Human){
		  		return new ConnectPlay(connectFourGame,id,0);  	
		    }
		    else{
		        return new ConnectPlay(connectFourGame,id,1);
		     }
		  }
}
