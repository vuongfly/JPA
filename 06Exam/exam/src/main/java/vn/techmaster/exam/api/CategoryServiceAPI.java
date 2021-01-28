package vn.techmaster.exam.api;

import java.util.List;

import vn.techmaster.exam.model.Category;

public interface CategoryServiceAPI {
    Category findCategoryById(Long id);

    List<Category> getAllCategory();
  
    void addCategory(Category category);
  
    void removeCategory(Category category);
  
    void updateCategory(Long categoryId, Category newCategory);
}
