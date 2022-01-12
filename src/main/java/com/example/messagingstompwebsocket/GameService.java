package com.example.messagingstompwebsocket;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
//import java.util.UUID;


@Service
@AllArgsConstructor
public class GameService {
  
   public Game getGame(){
     return new Game();
   } 



}