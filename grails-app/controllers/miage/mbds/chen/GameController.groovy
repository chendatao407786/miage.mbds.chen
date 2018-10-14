package miage.mbds.chen

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured("ROLE_ADMIN")
class GameController {

    GameService gameService
    UserGameService userGameService
    DefineWinnerService defineWinnerService
    SearchUsersInGameService searchUsersInGameService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static responseFormats = ['json', 'xml']
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        if(gameService.list().size()>0){
            for(int i = 0; i < gameService.list().size(); i++){
                defineWinnerService.setResult(
                        gameService.list().get(i).user1.userGame[0],
                        gameService.list().get(i).user2.userGame[0]
                )
            }
        }
        respond gameService.list(params), model:[gameList: Game.list(), gameCount: gameService.count()]
    }

    def show(Long id) {
        respond gameService.get(id)
    }

    def create() {
        respond new Game(params)
    }

    def save(Game game) {
        if (game == null) {
            notFound()
            return
        }

        try {
            gameService.save(game)
        } catch (ValidationException e) {
            respond game.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'game.label', default: 'Game'), game.id])
                redirect game
            }
            '*' { respond game, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond gameService.get(id)
    }

    def update(Game game) {
        if (game == null) {
            notFound()
            return
        }

        try {
            gameService.save(game)
        } catch (ValidationException e) {
            respond game.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'game.label', default: 'Game'), game.id])
                redirect game
            }
            '*'{ respond game, [status: OK] }
        }
    }
    def deleteUserGame(Long id) {
        Game game = Game.get(id)
        def userGameInstance = UserGame.findAllByGame(game);
        print(userGameInstance)
//        for(int i = 0; i < userGameInstance.size();i++){
//            def userGame = userGameInstance.get(i)
//            game.removeFromUserGame(userGame)
//            userGameService.delete(Long.valueOf(userGame.id))
//        }
    }
    def delete(Long id) {
        deleteUserGame(id)
        if (id == null) {
            notFound()
            return
        }

        gameService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'game.label', default: 'Game'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(scode: 'game.label', default: 'Game'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    def users(int id){
        def users = searchUsersInGameService.users(id)
        render users as JSON
    }
}
