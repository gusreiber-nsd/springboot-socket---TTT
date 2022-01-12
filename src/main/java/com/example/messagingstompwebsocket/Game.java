package com.example.messagingstompwebsocket;

import java.util.Arrays;
import java.util.UUID;

public class Game {

  private String id = UUID.randomUUID().toString();
  private boolean is3d = false;
  private int SIZE = 3;
  private int FIRST = (is3d)? SIZE : 1;
  private int[][][] state = new int[FIRST][SIZE][SIZE]; 
  
  private Player[] players;

  public Game() {
    System.out.println(this);
  }

  

  public int[][][] getState(String pos){
    try{
      int i = Integer.parseInt(pos);
      int f = (is3d)? i/FIRST : 0;
      i = i/FIRST;
      if(state[f][ i / SIZE ][ i % SIZE] == 0)  
        state[f][ i / SIZE ][ i % SIZE] = 1; 
      else
        throw new NumberFormatException();
    }catch(NumberFormatException e){
      System.out.println("????????? not a number!!!!");
    }
    System.out.println(Arrays.deepToString(state));
    return this.state;
  }
  public int[][][] getContent(){
    return this.state;
  }
  public String getId(){
    return this.id;
  }
  
  @Override
  public String toString(){
    return "GAME: " + this.id;
  }


}