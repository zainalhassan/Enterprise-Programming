function logText(text) { console.log("Text from server is %o.", text); }

logText("Example from server");

$.ajax({ url: "server-result.txt", success: logText });

function alertText(text) { alert("Text from server is " + text); }

$.ajax({ url: "server-result.txt", success: alertText });