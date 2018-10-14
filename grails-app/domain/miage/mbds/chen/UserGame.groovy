package miage.mbds.chen

class UserGame {

    static belongsTo = [
            user : User,
            game : Game
    ]
    User user
    int score
    String result
    static constraints = {
        result nullable: true
    }
//    String toString(){
//        return user.username + " on match : "+ game.id
//    }
    User getUser(){
        return user
    }
    static mapping = {
        tags cascade: "all-delete-orphan"
    }
}
