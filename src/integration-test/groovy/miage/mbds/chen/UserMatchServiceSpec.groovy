package miage.mbds.chen

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UserMatchServiceSpec extends Specification {

    UserMatchService userMatchService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new UserMatch(...).save(flush: true, failOnError: true)
        //new UserMatch(...).save(flush: true, failOnError: true)
        //UserMatch userMatch = new UserMatch(...).save(flush: true, failOnError: true)
        //new UserMatch(...).save(flush: true, failOnError: true)
        //new UserMatch(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //userMatch.id
    }

    void "test get"() {
        setupData()

        expect:
        userMatchService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<UserMatch> userMatchList = userMatchService.list(max: 2, offset: 2)

        then:
        userMatchList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        userMatchService.count() == 5
    }

    void "test delete"() {
        Long userMatchId = setupData()

        expect:
        userMatchService.count() == 5

        when:
        userMatchService.delete(userMatchId)
        sessionFactory.currentSession.flush()

        then:
        userMatchService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        UserMatch userMatch = new UserMatch()
        userMatchService.save(userMatch)

        then:
        userMatch.id != null
    }
}
