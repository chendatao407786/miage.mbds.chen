package miage.mbds.chen

class Game {

    User user1
    User user2
//    Date date = new Date()


    static constraints = {
        user1 nullable: true
        user2 nullable: true
    }
    String toString(){
        return id
    }
}
