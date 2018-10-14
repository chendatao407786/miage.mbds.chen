package miage.mbds.chen

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured("ROLE_ADMIN")
class UserController {
    UserService userService
    UserGameService userGameService
    GameService gameService
    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userService.list(params), model:[userCount: userService.count(),userList: User.list()]
    }
    def show(Long id) {
        respond userService.get(id)
    }

    def create() {
        respond new User(params)
    }

    def creater() {
        def file = request.getFile('picture')
        def fileName = file.getOriginalFilename()

        if (file.isEmpty()) {
            retunrn ;
        }
        def filePath = "${grailsApplication.config.assets.image.filePath}/${fileName}"

        File fileDes = new File(filePath)
        file.transferTo(fileDes)

        def fileUrl = "${grailsApplication.config.assets.image.fileUrl}/${fileName}"
        User user = new User(
                username: params.username,
                password: params.password,
                picture: fileUrl
        )
        userService.save(user)
        redirect action: 'index',controller: 'user'
    }

    def save(User user) {
        if (user == null) {
            notFound()
            return
        }


        try {
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond userService.get(id)
    }

    def update(User user) {
        if (user == null) {
            notFound()
            return
        }

        try {
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*'{ respond user, [status: OK] }
        }
    }

    def deleteUserGame(Long id) {
        User user = User.get(id)
        def userGameInstance = UserGame.findAllByUser(user);
        for(int i = 0; i < userGameInstance.size();i++){
            def userGame = userGameInstance.get(i)
            user.removeFromUserGame(userGame)
            userGameService.delete(Long.valueOf(userGame.id))
        }
    }

    def deleteUserRole(Long id){
        User user = User.get(id)
        UserRole.removeAll(user)
        def userRole = UserRole.findAllByUser(user)
        print(userRole)
    }

    def deleteGame(Long id) {
        User user = User.get(id)
        def gameInstanceUser1 = Game.findAllByUser1(user)
        for(int i = 0; i < gameInstanceUser1.size();i++){
            def game = gameInstanceUser1.get(i)
            gameService.delete(Long.valueOf(game.id))
        }
        def gameInstanceUser2 = Game.findAllByUser2(user)
        for(int i = 0; i < gameInstanceUser2.size();i++){
            def game = gameInstanceUser2.get(i)
            gameService.delete(Long.valueOf(game.id))
        }
    }
    def delete(Long id) {
        deleteUserGame(id)
        deleteUserRole(id)
        deleteGame(id)
        if (id == null) {
            notFound()
            return
        }

        userService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
