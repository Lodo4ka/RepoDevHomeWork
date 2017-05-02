import abstractfactory.AbstractTeamFactory;
import factory.ProjectTeamFactory;
import factory.Worker;

/**
 * Created by lodo4ka on 02/05/2017.
 */
public class EntryPoint {

    public static void main(String[] args) {
        AbstractTeamFactory abstractTeamFactory = new AbstractTeamFactory();

        ProjectTeamFactory projectTeamFactoryFirst = abstractTeamFactory.getTeam("banking");
        Worker developerBank = projectTeamFactoryFirst.getTeamMember("developer");
        developerBank.work();
        Worker testerBank = projectTeamFactoryFirst.getTeamMember("tester");
        testerBank.work();
        Worker managerBank = projectTeamFactoryFirst.getTeamMember("manager");
        managerBank.work();

        System.out.println();

        ProjectTeamFactory projectTeamFactorySecond = abstractTeamFactory.getTeam("website");
        Worker developerWeb = projectTeamFactorySecond.getTeamMember("developer");
        developerWeb.work();
        Worker testerWeb = projectTeamFactorySecond.getTeamMember("tester");
        testerBank.work();
        Worker managerWeb = projectTeamFactorySecond.getTeamMember("manager");
        managerWeb.work();
    }
}
