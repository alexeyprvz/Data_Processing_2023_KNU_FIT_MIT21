package knu.fit.mit.lab.controller;

import knu.fit.mit.lab.entity.GrndEntity;
import knu.fit.mit.lab.repository.GrndRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/back-end/api/granades")
@CrossOrigin(origins = "*")
public class GrndController {

    @Autowired
    GrndRepository grndRepository;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public GrndEntity postGrnd (@RequestBody GrndEntity grnd){
        return grndRepository.save(grnd);
    }

    @GetMapping("/get")
    public List<GrndEntity> getGrnd(){
        return grndRepository.findAll();
    }

    @PutMapping ("/update/{id}")
    public GrndEntity putGrnd(@PathVariable(name = "id") int id, @RequestBody GrndEntity newGrnd){
        GrndEntity updatedGrnd = grndRepository.findById(id)
                .orElseThrow(()->new ResourceAccessException("Not found GrndEntity with such id: " + id));
        updatedGrnd.setName(newGrnd.getName());
        updatedGrnd.setType(newGrnd.getType());
        updatedGrnd.setWeight(newGrnd.getWeight());
        updatedGrnd.setImg(newGrnd.getImg());
        return grndRepository.save(updatedGrnd);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGrnd(@PathVariable(name = "id") int id){
        grndRepository.deleteById(id);
    }

}
