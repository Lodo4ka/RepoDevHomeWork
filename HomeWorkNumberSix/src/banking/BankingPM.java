package banking;

import factory.ProjectManager;

/**
 * Created by lodo4ka on 01/05/2017.
 */
public class BankingPM implements ProjectManager {
    @Override
    public void managerProject() {
        System.out.println("Banking PM manages banking project...");
    }
}
