package miage.mbds.chen

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UserGameServiceSpec extends Specification {

    UserGameService userGameService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new UserGame(...).save(flush: true, failOnError: true)
        //new UserGame(...).save(flush: true, failOnError: true)
        //UserGame userGame = new UserGame(...).save(flush: true, failOnError: true)
        //new UserGame(...).save(flush: true, failOnError: true)
        //new UserGame(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //userGame.id
    }

    void "test get"() {
        setupData()

        expect:
        userGameService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<UserGame> userGameList = userGameService.list(max: 2, offset: 2)

        then:
        userGameList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        userGameService.count() == 5
    }

    void "test delete"() {
        Long userGameId = setupData()

        expect:
        userGameService.count() == 5

        when:
        userGameService.delete(userGameId)
        sessionFactory.currentSession.flush()

        then:
        userGameService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        UserGame userGame = new UserGame()
        userGameService.save(userGame)

        then:
        userGame.id != null
    }
}
