package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.ActorInfo;
import ge.ibsu.demo.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<ActorInfo> getAllActors(){
        return actorRepository.findActors();
    }
}
