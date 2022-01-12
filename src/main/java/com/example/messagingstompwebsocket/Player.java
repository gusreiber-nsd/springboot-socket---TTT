package com.example.messagingstompwebsocket;

import java.util.UUID;
import lombok.Data;

@Data
public class Player {

    private String id = UUID.randomUUID().toString();
  
}