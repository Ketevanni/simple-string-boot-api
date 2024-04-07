package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.ActorInfo;
import ge.ibsu.demo.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Query("select new ge.ibsu.demo.dto.ActorInfo(a.first_name, a.last_name) from Actor a")
    List<ActorInfo> findActors();
}
