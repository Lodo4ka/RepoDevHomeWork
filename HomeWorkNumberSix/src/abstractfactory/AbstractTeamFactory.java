package abstractfactory;

import banking.BankingTeamFactory;
import factory.ProjectTeamFactory;
import website.WebsiteTeamFactory;

/**
 * Created by lodo4ka on 02/05/2017.
 */
public class AbstractTeamFactory {

    public ProjectTeamFactory getTeam(String team){
        if("banking".equals(team)){
            return new BankingTeamFactory();
        }
        else if("website".equals(team)){
            return new WebsiteTeamFactory();
        }
        else {
            return null;
        }
    }
}
