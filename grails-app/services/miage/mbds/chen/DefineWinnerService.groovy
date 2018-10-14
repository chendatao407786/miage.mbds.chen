package miage.mbds.chen

import grails.gorm.transactions.Transactional

@Transactional
class DefineWinnerService {

    void setResult(UserGame userGame1, UserGame userGame2){
        if(userGame1 != null && userGame2 !=null){
            if(userGame1.score > userGame2.score){
                userGame1.result = "Winner"
                userGame2.result = "Looser"
            }else if(userGame1.score < userGame2.score){
                userGame2.result = "Winner"
                userGame1.result = "Looser"
            }else {
                userGame1.result = "Even"
                userGame2.result = "Even"
            }
        }
    }
}
