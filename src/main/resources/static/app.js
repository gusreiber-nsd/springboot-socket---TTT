var stompClient = null;

var myBody = document.getElementById("myBody");
myBody.addEventListener(
  'click', 
  event => {
    console.log(event);
    alert("my body");
  }
);


var myHead = $("#myBody .head");

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
      $("#conversation").show();
    }
    else {
      $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
  var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/ttt', function (move) {
        showMove(JSON.parse(move.body).content);
    });
    console.log('create game...');
    console.log(socket);
    console.log(frame);
    console.log(stompClient);
    doGame();
  });
}

function disconnect() {
  if (stompClient !== null) {
      stompClient.disconnect();
  }
  setConnected(false);
  console.log("Disconnected");
}
function doGame(){
  stompClient.send("/app/start",{},JSON.stringify({}));
}
function sendName() {
  stompClient.send("/app/game", {}, JSON.stringify({'move': $("#name").val()}));
}

function showMove(message) {
  var $ttt = $("#ttt").empty();
  for(var i = 0; i < message[0].length; i ++){
    var $tr = $("<tr />").appendTo($ttt);
    for(var j = 0; j < message[0][i].length; j++){
      var $td = $("<td>").appendTo($tr);
      $td.append(message[0][i][j]);      
    }
  }
  
}

$(function () {
  $("form").on('submit', function (e) {
      e.preventDefault();
  });
  $( "#connect" ).click(function() { connect(); });
  $( "#disconnect" ).click(function() { disconnect(); });
  $( "#send" ).click(function() { sendName(); });
});