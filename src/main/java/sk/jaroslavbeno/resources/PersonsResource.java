package sk.jaroslavbeno.resources;

import sk.jaroslavbeno.model.Person;
import sk.jaroslavbeno.services.PersonService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonsResource {

    @GET
    public List<Person> getPersons(@QueryParam("name") String name){
        if(name!=null){
            return PersonService.getPersonService().getAllPersonsWithName(name);
        }
        return PersonService.getPersonService().getAllPersons();
    }

    @GET
    @Path("/{personId}")  // /persons/{personId}/phones/{phoneId}.
    public Person getPersonById(@PathParam("personId") long personId){
        return PersonService.getPersonService().getPersonById(personId);
    }

    @POST
    public Person addPerson(Person person){
        return PersonService.getPersonService().addPerson(person);
    }

    @PUT
    @Path("{personId}")
    public Person updatePerson(Person person, @PathParam("personId") long personId){
        person.setId(personId);
        return PersonService.getPersonService().updatePerson(person);
    }

    @DELETE
    @Path("/{personId}")
    public void deletePerson(@PathParam("personId") Long personId){
        PersonService.getPersonService().deletePerson(personId);
    }


}
