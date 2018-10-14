package miage.mbds.chen

import grails.gorm.services.Service

@Service(UserGame)
interface UserGameService {

    UserGame get(Serializable id)

    List<UserGame> list(Map args)

    Long count()

    void delete(Serializable id)

    UserGame save(UserGame userGame)

}