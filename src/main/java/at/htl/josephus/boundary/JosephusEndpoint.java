package at.htl.josephus.boundary;

import at.htl.josephus.control.Josephusring;
import at.htl.josephus.control.Node;
import at.htl.josephus.control.RoundRepository;
import at.htl.josephus.entity.Round;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;

@Path("/josephus")
public class JosephusEndpoint {

    // ...

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createJosephusRing(JsonObject json, @Context UriInfo uriInfo) {

        int noOfPersons;
        int fatalNo;

        /*
         *  Einlesen des json - Objekt im Body des Requests in
         *        - noOfPersons und
         *        - fatalNo
         *  Falls das json-Objekt nicht korrekt ist, wird ein BAD_REQUEST zurückgegeben
         *  --> siehe Beispiel im requests.http
         */

        // ...

        /*
        Erstelle einen Josephusring mit obigen noOfPersons und fatalNo
        Gehe den output zeilenweise durch und speichere jede Zeile in der DB
        */

        // ...

        /*
        Ist alles in Ordnung wird 201 zurückgegeben und die Location mit dem
         */

        // ...
        return null;
    }

    /**
     *
     * http://localhost:8080/api/josephus/58f2e544-36fc-4c07-9f8c-d0460ab10c10
     *
     * @param uuid als String
     * @return alle Zeilen des Outputs als JsonString
     */
    @GET
    @Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOneRing(String uuid) {
        return null;
    }

    /**
     * [
     * { "uuid": "xxx", "no_of_rounds": 4},
     * { "uuid": "yyy", "no_of_rounds": 7},
     * ..,
     * ]
     *
     * @param uuid as String zB 58f2e544-36fc-4c07-9f8c-d0460ab10c10
     * @return 201 and json-array
     */
    @GET
    @Path("/count/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response noOfRoundsPerUuid(String uuid) {
        return null;
    }
}
