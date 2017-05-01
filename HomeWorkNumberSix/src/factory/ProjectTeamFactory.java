package factory;

/**
 * Created by lodo4ka on 01/05/2017.
 */
public interface ProjectTeamFactory {
    Developer getDeveloper();
    Tester getTester();
    ProjectManager getProjectManager();
}
