<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainNav" />
        <g:set var="entityName" value="${message(code: 'game.label', default: 'Game')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <asset:stylesheet src="game_index.css"></asset:stylesheet>

    </head>
    <body>

        <div class="showGameList">
        <g:each in="${gameList}" var="game" status="i">
            <span style="text-align: center;display: block;font-size: 20px">Match id: ${game.id}</span>
            <div class="game">
                <div class="user_game" style="line-height: 100px;width: 200px;font-size: 30px">${miage.mbds.chen.UserGame.findWhere(user: game.user1, game: game).result}</div>
                <div class="user_game">
                    <img src="${game.user1.picture}"/>
                    <span>${game.user1.username}</span>
                </div>
                <div class="score">
                    <div class="score_user1 score_user">Score: <span class="userScore1">${miage.mbds.chen.UserGame.findWhere(user: game.user1, game: game).score}</span></div>
                    <div class="score_user2 score_user">Score: <span class="userScore2">${miage.mbds.chen.UserGame.findWhere(user: game.user2, game: game).score}</span></div>
                    %{--<div class="score_user2 score_user">Score: <span class="userScore2">${game.user2.userGame}</span></div>--}%
                </div>
                <div class="user_game">
                    <img src="${game.user2.picture}"/>
                    <span>${game.user2.username}</span>
                </div>
                <div class="user_game" style="line-height: 100px;width: 200px;font-size: 30px">${miage.mbds.chen.UserGame.findWhere(user: game.user2, game: game).result}</div>
            </div>
            <hr>
        </g:each>

    </div>
    <asset:javascript src="scoreLine.js"></asset:javascript>


    </body>

</html>