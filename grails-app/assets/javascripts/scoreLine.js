
var setWidth = function () {

}
for(var i = 0; i < document.getElementsByClassName("userScore1").length; i++){
    var widthUser1 = parseFloat(document.getElementsByClassName("userScore1")[i].firstChild.nodeValue)
    var widthUser2 = parseFloat(document.getElementsByClassName("userScore2")[i].firstChild.nodeValue)
// console.log(document.getElementsByClassName("userScore1")[0].firstChild.nodeValue)
    width1 = widthUser1/(widthUser1+widthUser2)
    width2 = 1 - width1
    width1 = String(width1*100)+"%"
    width2 = String(width2*100)+"%"

    var a = document.getElementsByClassName("score_user1")[i].style.width = width1
    var a = document.getElementsByClassName("score_user2")[i].style.width = width2
}

// document.getElementById("score_user2").style.width = width2