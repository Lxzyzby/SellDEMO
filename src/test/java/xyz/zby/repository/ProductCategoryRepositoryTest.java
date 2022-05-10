package xyz.zby.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.zby.dataobject.ProductCategory;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

//    @Test
//    public void findOneTest() {
//        Optional<ProductCategory> productCategoryOptional = repository.findById(1);
//        if (productCategoryOptional.isPresent()) {
//            ProductCategory productCategory = productCategoryOptional.get();
//            System.out.println(productCategory.toString());
//        }
//    }
    @Test
//    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(4);
        productCategory.setCategoryName("热销榜");
        productCategory.setCategoryType(2);
//        System.out.println(productCategory.toString());
        repository.save(productCategory);
        productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}