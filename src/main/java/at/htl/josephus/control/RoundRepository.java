package at.htl.josephus.control;

import at.htl.josephus.entity.Round;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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



}
