package cl.ucm.serviceproduct.controller;

import cl.ucm.serviceproduct.entities.Category;
import cl.ucm.serviceproduct.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// localhost:8080/category

@RestController
@RequestMapping(path = "category")
public class CategoryController {

    @Autowired
    private CategoryService service;


    @GetMapping
    public ResponseEntity<?> categories(){
        return ResponseEntity.ok(service.categoryList());
    }

    @PostMapping
    public ResponseEntity<?> save( @RequestBody Category category){
        return ResponseEntity.ok(service.save(category));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update( @PathVariable int id, @RequestBody Category category){
        Optional<Category> optional = service.edit(id, category);
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete( @PathVariable int id){
        Optional<Category> optional = service.delete(id);
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }



   /* @GetMapping
    public ResponseEntity<?> testHello(){
        Map<String, String> data = new HashMap<>();
        data.put("saludo", "Hola mundo!");
        return ResponseEntity.ok(data);
    }
    @GetMapping(path = "{name}")
    public ResponseEntity<?> testHello2( @PathVariable String name){
        Map<String, String> data = new HashMap<>();
        data.put("saludo", "Hola "+name);
        return ResponseEntity.ok(data);
    }*/

}
