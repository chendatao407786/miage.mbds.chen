$(document).ready(function () {
    $.ajax({
        // url: "${createLink(controller:'game',action:'index()')}",
        url: "http://localhost:8080/api/userGame/",
        type: "GET",
        data: {id : gameId},
        dataType: 'json',
        success : function(data){
            changeSelectOption(data)
        },
        error: function () {
            console.log("failed")
        }
    })
})