package vagrant.localrule;

import vagrant.GlobalStatusCommand;
import vagrant.vboxmanage.ListVmsCommand;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Named
@Path("/localrules")
public class LocalRuleEndpoint {
    @Inject
    AsyncLocalRuleService asyncLocalRuleService;

    @GET
    @Produces("application/json")
    public List<LocalRule> list() {
        return new LocalRuleService(new ListVmsCommand(), new GlobalStatusCommand())
                .list();
    }

    @POST
    @Path("up")
    public void localRuleUp(@QueryParam("base") String base, @QueryParam("isFast") boolean isFast) {
        java.nio.file.Path path = Paths.get(base);
        if (!Files.isDirectory(path)) {
            throw new WebApplicationException("'base' must be directory!");
        }
        asyncLocalRuleService.localRulUp(path, isFast);
    }

    @POST
    @Path("normalUp")
    public void up(@QueryParam("id") String id) {
        asyncLocalRuleService.up(id);
    }


    @POST
    @Path("halt")
    public void halt(@QueryParam("id") String id) {
        asyncLocalRuleService.halt(id);
    }

    @POST
    @Path("destroy")
    public void destroy(@QueryParam("id") String id) {
        asyncLocalRuleService.destroy(id);
    }
}
