package at.htl.josephus.control;

import at.htl.josephus.entity.Round;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.JsonString;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class RoundRepository implements PanacheRepository<Round> {

  @Inject
  EntityManager em;

  public Round save(Round round) {
    return em.merge(round);
  }


  public JsonString findOneRing(String uuid) {

    var query = getEntityManager().createQuery("Select r from Round r where r.uuid=:uuid ", Round.class);
    query.setParameter("uuid", uuid);
    return (JsonString) query.getResultList();

  }

  public JsonString noOfRoundsPerUuid(String uuid) {

    var query = getEntityManager().createQuery("Select r.uuid, count(r) from Round r where r.uuid=:uuid ", Round.class);
    query.setParameter("uuid", uuid);
    return (JsonString) query.getResultList();

  }
}
