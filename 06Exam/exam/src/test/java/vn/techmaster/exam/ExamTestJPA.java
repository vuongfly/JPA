package vn.techmaster.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import vn.techmaster.exam.model.Category;
import vn.techmaster.exam.repository.CategoryRepository;
import vn.techmaster.exam.service.CategoryService;

@DataJpaTest
public class ExamTestJPA {
    
    @Autowired CategoryRepository categoryRepository;

    @Autowired CategoryService cateService = new CategoryService();

    private List<Category> listCategories = new ArrayList<>();

    @BeforeEach
    public void before() {
        // listCategories = cateService.getAllCategory();
    }

    @Test
    public void testAddProduct() {
        
    }
    @Test
    public void testAddCategory() {
        Category c = new Category();
        c.setName("test category");
        cateService.addCategory(c);
        assertThat(listCategories.size()).isPositive();
    }
}
