package knu.fit.mit.exam.controller;

import knu.fit.mit.exam.entity.OfficerEntity;
import knu.fit.mit.exam.repository.OfficerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/api/officers")
@Slf4j
public class OfficerController {

    @Autowired
    OfficerRepository officerRepository;

    @GetMapping("/get")
    public List<OfficerEntity> getEntities(){
        List<OfficerEntity> list;
        log.info("[OFFICER CONTROLLER] Before GET");
        list = officerRepository.findAll();
        log.info("[OFFICER CONTROLLER] After GET Found {} officers", list.size());
        return list;
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public OfficerEntity postEntity(@RequestBody OfficerEntity officerEntity){
        log.info("[OFFICER CONTROLLER] After POST Found new officer {} ", officerEntity);
        return officerRepository.save(officerEntity);
    }

    @PutMapping("/update/{id}")
    public OfficerEntity putEntity(@PathVariable long id, @RequestBody OfficerEntity newEntity){
        OfficerEntity updatedEntity = officerRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Not found OfficerEntity with id: " + id));
        updatedEntity.setName(newEntity.getName());
        updatedEntity.setAge(newEntity.getAge());
        updatedEntity.setRating(newEntity.getRating());
        log.info("[OFFICER CONTROLLER] After PUT Found updated officer {} ", updatedEntity);
        return officerRepository.save(updatedEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id){
        OfficerEntity deletedEntity = officerRepository.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found OfficerEntity with id: "+id));
        log.info("[OFFICER CONTROLLER] After DELETE Found deleted officer {} ", deletedEntity);
        officerRepository.deleteById(id);
    }
}
