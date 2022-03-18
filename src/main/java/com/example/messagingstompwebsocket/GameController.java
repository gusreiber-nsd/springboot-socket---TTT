package com.example.messagingstompwebsocket;
//package com.example.messagingstompwebsocket.model.Move;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

@Controller
public class GameController {

  private Game ttt;

  @MessageMapping("/move")
  @SendTo("/topic/public")
  public Move sendMessage(@Payload Move myMove) {
    return myMove;
  }

  @MessageMapping("/start")
  @SendTo("/topic/ttt")
  public ResponseEntity<String> start() {
    this.ttt = new GameService().getGame();
    System.out.println(ttt.getId());

    return ResponseEntity.ok().body("?????????");
  }

  @MessageMapping("/game")
  @SendTo("/topic/ttt")
  public Game game(Move message) throws Exception {
    // System.out.println(ttt);
    Thread.sleep(10); // simulated delay
    int[][][] gs = ttt.getState(HtmlUtils.htmlEscape(message.getMove()));

    System.out.println("gameContoler says: " + Arrays.deepToString(gs));

    return ttt;
  }

}