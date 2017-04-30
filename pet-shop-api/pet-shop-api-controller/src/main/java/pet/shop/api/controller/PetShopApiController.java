/**
 *
 */
package pet.shop.api.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Pet Shop API controller.
 */
@Path("/pet")
public class PetShopApiController {

    @GET()
    @Produces(MediaType.TEXT_PLAIN)
    public String reteieveAllPets() {

        return "Hello World";
    }

}
