package vagrant.localrule;

import vagrant.GlobalStatusCommand;
import vagrant.vboxmanage.ListVmsCommand;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Named
@Path("/localrules")
public class LocalRuleEndpoint {
    @GET
    @Produces("application/json")
    public List<LocalRule> list() {
        return new LocalRuleService(new ListVmsCommand(), new GlobalStatusCommand())
                .list();
    }
}
