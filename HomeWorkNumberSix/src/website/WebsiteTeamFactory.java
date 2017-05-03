package website;

import banking.BankingPM;
import banking.JavaDeveloper;
import banking.QATester;
import factory.ProjectTeamFactory;
import factory.Worker;

/**
 * Created by lodo4ka on 01/05/2017.
 */
public class WebsiteTeamFactory extends ProjectTeamFactory{

    @Override
    public Worker getTeamMember(String member) {
        if("developer".equals(member)){
            return new PhpDeveloper();
        }
        else if("manager".equals(member)){
            return new WebsitePM();
        }
        else if("tester".equals(member)){
            return new ManualTester();
        }
        return null;
    }
    }

