package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

@Controller
public class GameController {

  private Game ttt;
  
  @MessageMapping("/start")
  public ResponseEntity<String> start() {
    this.ttt = new GameService().getGame();
    return ResponseEntity.ok(ttt.getId());
  }
  
  @MessageMapping("/game")
  @SendTo("/topic/ttt")
  public Game greeting(HelloMessage message) throws Exception {
    System.out.println(ttt);
    Thread.sleep(10); // simulated delay
    int[][][] gs = ttt.getState(HtmlUtils.htmlEscape(message.getName()));
    System.out.println("gameContoler says: " + Arrays.deepToString(gs));
    return ttt;
    //return ResponseEntity.ok(ttt);
  }

}