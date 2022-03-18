package com.example.messagingstompwebsocket;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
//import java.util.UUID;


@Service
@AllArgsConstructor
public class GameService {
  
   public Game getGame(){
     System.out.println();
     System.out.println("!!!!! GAME SERVICE!!!!");
     System.out.println();
     System.out.println();
     return new Game();
   } 



}