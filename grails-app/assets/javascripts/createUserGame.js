$(document).ready(function () {
        $('#game').change(function(){
            var gameId = $('#game').val()
            console.log(gameId)
            $.ajax({
                // url: "${createLink(controller:'game',action:'index()')}",
                url: "http://localhost:8080/game/users",
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
        function changeSelectOption(data) {
            console.log(data[0].id+":"+data[0].username)

            var option1 = $('<option></option>').attr("value",data[0].id).text(data[0].username)
            var option2 = $('<option></option>').attr("value",data[1].id).text(data[1].username)
            $('#user').empty().append(option1).append(option2)
        }
})
