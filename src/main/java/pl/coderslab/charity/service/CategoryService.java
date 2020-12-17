package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Category;

import java.util.List;


public interface CategoryService {
    List<Category> findAllCategories();

    Category findById(Long id);

    void add(Category category);

    List<Category> getCategory();
}
