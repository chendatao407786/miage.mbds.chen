package miage.mbds.chen

import grails.gorm.transactions.Transactional

@Transactional
class SearchUsersInGameService {
    User[] users(int gameId){
        def users = new User[2]
        def user1 = Game.list().get(gameId-1).user1
        def user2 = Game.list().get(gameId-1).user2
        users[0] = user1
        users[1] = user2
        return users
    }


}
