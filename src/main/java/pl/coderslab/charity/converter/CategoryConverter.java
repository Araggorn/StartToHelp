package pl.coderslab.charity.converter;


import pl.coderslab.charity.dto.CategoryDTO;
import pl.coderslab.charity.entity.Category;

public class CategoryConverter {

    public static CategoryDTO toDto(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
