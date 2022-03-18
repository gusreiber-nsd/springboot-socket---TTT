package com.example.messagingstompwebsocket;

public class Move {

  private String move;
  private String player;
  private String gameId;
  private char   symbol;

  public Move() {}

  public Move(String name) {
    System.out.println("make move " + name);
    this.move = move;
  }
  public Move(String name, String player, String gameId, char symbol) {
    this.move   = move;
    this.player = player;
    this.gameId = gameId;
    this.symbol = symbol;
  }

  public char getSymbol(){
    return this.symbol;
  }

  public String getMove() {
    System.out.println("get move ");
    return this.move;
  }
  
  public String getPlayer() {
    System.out.println("get plya ");
    return this.player;
  }
  
  public String getGame() {
    System.out.println("get move ");
    return this.gameId;
  }

  public void setPlayer(String player){
    this.player = player;
  }
  public void setMove(String move) {
    System.out.println("set move " + move);
    this.move = move;
  }
}