package cl.ucm.serviceproduct.service;


import cl.ucm.serviceproduct.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category save(Category category);
    List<Category> categoryList();
    Optional<Category> edit(int id, Category category);
    Optional<Category> delete(int id);
}
