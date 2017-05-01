package banking;

import factory.Developer;
import factory.ProjectManager;
import factory.ProjectTeamFactory;
import factory.Tester;

/**
 * Created by lodo4ka on 01/05/2017.
 */
public class BankingTeamFactory implements ProjectTeamFactory{
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
