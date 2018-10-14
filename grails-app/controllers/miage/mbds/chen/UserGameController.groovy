package miage.mbds.chen

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured("ROLE_ADMIN")
class UserGameController {

    UserGameService userGameService
//    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userGameService.list(params), model:[userGameCount: userGameService.count()]
    }
    def show(Long id) {
        respond userGameService.get(id)
    }

    def create() {
        respond new UserGame(params)
    }

    def isExist(UserGame userGame){
        def ifExistAlready = false
        def userGameList = UserGame.findAll(
                "from UserGame as ug where ug.game.id = ? and ug.user.id = ?", [
                    java.lang.Long.valueOf(userGame.game['id']),
                    java.lang.Long.valueOf(userGame.user['id'])

                 ]
        )
        print(userGameList)
        if(userGameList.size() == 0){
            ifExistAlready = false
        }else {
            ifExistAlready = true
        }
        return ifExistAlready
    }

    def save(UserGame userGame) {
        if (userGame == null) {
            notFound()
            return
        }
        print(isExist(userGame))
            try {
                if (isExist(userGame)){
                    render(text: "Creation failed, this result is exist already", contentType: "text/html", encoding: "UTF-8")
                }else {
                    userGameService.save(userGame)
                    request.withFormat {
                        form multipartForm {
                            flash.message = message(code: 'default.created.message', args: [message(code: 'userGame.label', default: 'UserGame'), userGame.id])
                            redirect userGame
                        }
                        '*' { respond userGame, [status: CREATED] }
                    }
                }
            } catch (ValidationException e) {
                respond userGame.errors, view:'create'
                return
            }


    }

    def edit(Long id) {
        respond userGameService.get(id)
    }

    def update(UserGame userGame) {
        if (userGame == null) {
            notFound()
            return
        }

        try {
            userGameService.save(userGame)
        } catch (ValidationException e) {
            respond userGame.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'userGame.label', default: 'UserGame'), userGame.id])
                redirect userGame
            }
            '*'{ respond userGame, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        userGameService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'userGame.label', default: 'UserGame'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userGame.label', default: 'UserGame'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
