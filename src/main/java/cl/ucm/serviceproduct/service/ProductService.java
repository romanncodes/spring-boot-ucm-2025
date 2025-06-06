package cl.ucm.serviceproduct.service;

import cl.ucm.serviceproduct.dto.in.ProductDtoIn;
import cl.ucm.serviceproduct.dto.out.ProductDtoOut;
import cl.ucm.serviceproduct.entities.Product;

import java.util.List;

public interface ProductService {

    Product save(ProductDtoIn in);
    List<Product> findAll();
    List<ProductDtoOut> productList();
}
