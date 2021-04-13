package com.example.forum.rest;

import com.example.forum.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/developers")
public class DeveloperRestControllerV1 {
    private List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L,"Vano1", "Valentain1"),
            new Developer(2L,"Vano2", "Valentain2"),
            new Developer(3L,"Vano3", "Valentain3"),
            new Developer(4L,"Vano4", "Valentain4")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll(){
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id){
        return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer) {
        this.DEVELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }
}
