/**
 *
 */
package pet.shop.api.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pet.shop.api.controller.model.PetControllerModel;
import pet.shop.api.controller.model.SpeciesControllerEnum;
import pet.shop.api.controller.model.StatusControlerEnum;

/**
 * Pet Shop API controller.
 */
@Path("/pet")
public class PetShopApiController {

    /**
     * Retrieve all pets.
     *
     * @return
     */
    @GET()
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public PetControllerModel retrieveAllPets() {

        final PetControllerModel petControllerModel = new PetControllerModel();
        petControllerModel.setName("Freddy");
        petControllerModel.setAge(10);
        petControllerModel.setSpecies(SpeciesControllerEnum.DOG);
        petControllerModel.setStatus(StatusControlerEnum.AVAILABLE_FOR_ADOPTION);

        return petControllerModel;
    }

}
