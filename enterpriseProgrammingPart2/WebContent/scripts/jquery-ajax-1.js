$(function() {
    $("#time-button-1").click(showTime1);
    $("#time-button-2").click(showTime2);
    $("#time-button-3").click(showTime3);
});


function showTime1() {
  $.ajax({ url: "server-time.jsp",
           success: showAlert,
           cache: false });
}

function showAlert(text, status) {
  alert(text);
}

function showTime2() {
  insertAjaxResult("server-time.jsp", 
                   "#time-result-1");
}

function insertAjaxResult(address, resultRegion) {
  $.ajax({ 
      url: address,
      success: 
        function(text) {
          insertText(text, resultRegion); 
        }
  });
}

function insertText(text, resultRegion) {
  $(resultRegion).html(text);
}

function showTime3() {
  $("#time-result-2").load("server-time.jsp");
}