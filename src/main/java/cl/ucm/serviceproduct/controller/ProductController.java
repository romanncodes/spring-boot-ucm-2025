package cl.ucm.serviceproduct.controller;


import cl.ucm.serviceproduct.dto.in.ProductDtoIn;
import cl.ucm.serviceproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// http://localhost:8085/product

@RestController
@RequestMapping(path = "product")

public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<?> findAllProducts(){
        //return ResponseEntity.ok(service.findAll());
        return ResponseEntity.ok(service.productList());
    }
    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ProductDtoIn in){
        return ResponseEntity.ok(service.save(in));
    }



}
