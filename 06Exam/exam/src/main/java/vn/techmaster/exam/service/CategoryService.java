package vn.techmaster.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.techmaster.exam.api.CategoryServiceAPI;
import vn.techmaster.exam.model.Category;
import vn.techmaster.exam.repository.CategoryRepository;

@Service
public class CategoryService implements CategoryServiceAPI {

    @Autowired CategoryRepository cateRepo;

    @Override
    public Category findCategoryById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Category> getAllCategory() {
        return cateRepo.findAll();
    }

    @Override
    public void addCategory(Category category) {
        cateRepo.save(category);
    }

    @Override
    public void removeCategory(Category category) {
        cateRepo.deleteById(category.getId());
    }

    @Override
    public void updateCategory(Long categoryId, Category newCategory) {
        cateRepo.findById(categoryId).get().setName(newCategory.getName());;
    }
    
}
