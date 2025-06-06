package cl.ucm.serviceproduct.service;

import cl.ucm.serviceproduct.entities.Category;
import cl.ucm.serviceproduct.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category save(Category category) {

        return repository.save(category);
    }

    @Override
    public List<Category> categoryList() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> edit(int id, Category category) {
        Optional<Category>optionalCategory =  repository.findById(id);
        if(optionalCategory.isPresent()){
            Category cat = optionalCategory.get();
            cat.setName(category.getName());
            repository.save(cat);
            return Optional.of(cat);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Category> delete(int id) {
        Optional<Category>optionalCategory =  repository.findById(id);
        if(optionalCategory.isPresent()){
            Category cat = optionalCategory.get();
            repository.delete(cat);
            return Optional.of(cat);
        }
        return Optional.empty();
    }
}
