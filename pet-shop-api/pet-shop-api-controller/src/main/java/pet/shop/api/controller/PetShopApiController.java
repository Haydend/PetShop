/**
 *
 */
package pet.shop.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pet.shop.api.controller.mapper.PetControllerMapper;
import pet.shop.api.controller.model.PetControllerModel;
import pet.shop.api.domain.Pet;
import pet.shop.api.service.PetShopApiService;

/**
 * Pet Shop API controller.
 */
@Path("/pet")
public class PetShopApiController {

    /** {@link PetShopApiService}. */
    private final PetShopApiService petShopApiService;

    /** {@link PetControllerMapper}. */
    private final PetControllerMapper petControllerMapper;

    /**
     * Constructor for {@link PetShopApiController}.
     *
     * @param petShopApiService
     *            {@link PetShopApiService}.
     * @param petControllerMapper
     *            {@link PetControllerMapper}.
     */
    @Inject
    public PetShopApiController(final PetShopApiService petShopApiService,
            final PetControllerMapper petControllerMapper) {

        this.petShopApiService = petShopApiService;
        this.petControllerMapper = petControllerMapper;
    }

    /**
     * Retrieve all pets.
     *
     * @return {@link List} of {@link PetControllerModel}.
     */
    @GET()
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PetControllerModel> retrieveAllPets() {

        final List<Pet> petList = petShopApiService.retrieveAllPets();

        final List<PetControllerModel> petControllerModelList = new ArrayList<>();
        for (final Pet pet : petList) {

            final PetControllerModel petControllerModel = petControllerMapper.mapTo(pet);
            petControllerModelList.add(petControllerModel);
        }

        return petControllerModelList;
    }

}
