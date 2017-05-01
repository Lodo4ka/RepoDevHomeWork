package website;

import factory.Developer;
import factory.ProjectManager;
import factory.ProjectTeamFactory;
import factory.Tester;

/**
 * Created by lodo4ka on 01/05/2017.
 */
public class WebsiteTeamFactory implements ProjectTeamFactory{
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePM();
    }
}
