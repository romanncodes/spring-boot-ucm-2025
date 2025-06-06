package cl.ucm.serviceproduct.service;

import cl.ucm.serviceproduct.dto.in.ProductDtoIn;
import cl.ucm.serviceproduct.dto.out.ProductDtoOut;
import cl.ucm.serviceproduct.entities.LogItem;
import cl.ucm.serviceproduct.entities.Product;
import cl.ucm.serviceproduct.repository.LogRepository;
import cl.ucm.serviceproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Autowired
    private LogRepository mongo;

    @Override
    public Product save(ProductDtoIn in) {
        Product product = new Product();
        product.setName(in.getName());
        product.setPrice(in.getPrice());
        product.setIdCategoryFk(in.getCategory());
        Product newProduct = repository.save(product);
        mongo.save(new LogItem(newProduct.getName()+Math.random(),
                        "Se crea producto "+newProduct.getName(),
                                    new Date()));
        return newProduct;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductDtoOut> productList() {
        return repository.findProducts();
    }
}
