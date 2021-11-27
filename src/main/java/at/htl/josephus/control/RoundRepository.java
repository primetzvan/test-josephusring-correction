package at.htl.josephus.control;

import at.htl.josephus.entity.Round;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RoundRepository implements PanacheRepository<Round> {



}
