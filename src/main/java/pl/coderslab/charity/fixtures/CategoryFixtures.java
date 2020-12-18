package pl.coderslab.charity.fixtures;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.service.CategoryService;
import java.util.Arrays;
import java.util.List;
@Component
public class CategoryFixtures {
    private CategoryService categoryService;
    private List<Category> categoryList = Arrays.asList(
            new Category(null, "badziongi"),
            new Category(null, "digi dongi"),
            new Category(null, "ubrania"),
            new Category(null, "sprzęty i narzędzia"),
            new Category(null, "zabawki"),
            new Category(null, "inne")
    );
    public CategoryFixtures(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void loadIntoDB() {
        for (Category category : categoryList){
            categoryService.add(category);
        }
    }
}
