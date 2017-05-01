package website;

import factory.ProjectManager;

/**
 * Created by lodo4ka on 01/05/2017.
 */
public class WebsitePM implements ProjectManager{
    @Override
    public void managerProject() {
        System.out.println("Website PM manages Website project...");
    }
}
