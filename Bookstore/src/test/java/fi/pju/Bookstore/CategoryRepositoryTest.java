package fi.pju.Bookstore;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import fi.pju.Bookstore.domain.Category;
import fi.pju.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	CategoryRepository categoryRepository;

	@Test
	public void findByCagegoryNameShouldReturnCategoryId() {
		List<Category> categories = categoryRepository.findByName("History");
		assertThat(categories.get(0).getCatId()).isEqualTo(1);
	}

	@Test
	public void createNewCategory() {
		Category category = new Category("Testaus");
		categoryRepository.save(category);
		assertThat(category.getCatId()).isNotNull();
	}
}
