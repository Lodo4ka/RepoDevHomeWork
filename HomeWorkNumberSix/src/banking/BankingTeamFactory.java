package banking;

import factory.*;

/**
 * Created by lodo4ka on 01/05/2017.
 */
public class BankingTeamFactory extends ProjectTeamFactory{

    @Override
    public Worker getTeamMember(String member) {
        if("developer".equals(member)){
            return new JavaDeveloper();
        }
        else if("manager".equals(member)){
            return new BankingPM();
        }
        else if("tester".equals(member)){
            return new QATester();
        }
        return null;
    }
}
