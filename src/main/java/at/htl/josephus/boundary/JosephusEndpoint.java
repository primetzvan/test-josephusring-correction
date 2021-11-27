package at.htl.josephus.boundary;

import at.htl.josephus.control.Josephusring;
import at.htl.josephus.control.Node;
import at.htl.josephus.control.RoundRepository;
import at.htl.josephus.entity.Round;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;

@Path("/josephus")
public class JosephusEndpoint {

  @Inject
  RoundRepository roundRepository;

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

    try {
      noOfPersons = json.getInt("no_of_persons");
      fatalNo = json.getInt("fatal_no");
    } catch (Exception e) {
      return Response
        .status(Response.Status.BAD_REQUEST)
        .entity(Json.createObjectBuilder()
          .add("message","json-object not correct")
          .build()
        ).build();
    }

        /*
        Erstelle einen Josephusring mit obigen noOfPersons und fatalNo
        Gehe den output zeilenweise durch und speichere jede Zeile in der DB
        */

    Josephusring josephusring = new Josephusring(noOfPersons, fatalNo);
    josephusring.findLastPerson();
    String last = josephusring.getOutput();

    last.lines()
        .forEach(line -> roundRepository
        .save(new Round(josephusring.getUuid().toString(),line)));

        /*
        Ist alles in Ordnung wird 201 zurückgegeben und die Location mit dem
         */
    return Response.created(uriInfo.getAbsolutePathBuilder().path(josephusring.getUuid().toString()).build()).build();

  }

  /**
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
