package miage.mbds

import miage.mbds.chen.Game
import miage.mbds.chen.Role
import miage.mbds.chen.User
import miage.mbds.chen.UserGame
import miage.mbds.chen.UserRole


import static miage.mbds.chen.Role.findOrSaveWhere

class BootStrap {

    def init = { servletContext ->
        def adminRole = Role.findOrSaveWhere(authority: 'ROLE_ADMIN')
        def normalRole = Role.findOrSaveWhere(authority: 'ROLE_NORMAL')

        def user = User.findOrSaveWhere(username: 'admin', password: '123', picture: 'http://localhost:8888/tpgrails/images/chen.jpg')
        UserRole.create(user,adminRole,true)

        def user1 = User.findOrSaveWhere(username: 'Chendatao', password: '123', picture: 'http://localhost:8888/tpgrails/images/chen.jpg')
        def user2 = User.findOrSaveWhere(username: 'Issoufi', password: '123', picture: 'http://localhost:8888/tpgrails/images/issoufi.jpg')
        def user3 = User.findOrSaveWhere(username: 'Serina', password: '123', picture: 'http://localhost:8888/tpgrails/images/30704260_10215948242607669_7236327905523141774_n.jpg')

        UserRole.create(user1,normalRole,true)
        UserRole.create(user2,normalRole,true)
        UserRole.create(user3,normalRole,true)
        def game1 = Game.findOrSaveWhere(user1: user1, user2:user2)
        def game2 = Game.findOrSaveWhere(user1: user1, user2: user3)
        game1.save()
        game2.save()

        def userGame1 = UserGame.findOrSaveWhere(user: user1, score: 10, game: game1).save()
        def userGame2 = UserGame.findOrSaveWhere(user: user2, score: 9,game: game1).save()

        def userGame3 = UserGame.findOrSaveWhere(user: user1, score: 10, game: game2).save()
        def userGame4 = UserGame.findOrSaveWhere(user: user3, score: 7, game: game2).save()
//
//        userGame1.save()
//        userGame2.save()

//        game.setUserGame1(userGame1)
//        game.setUserGame2(userGame2)


    }
    def destroy = {
    }
}
