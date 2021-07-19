package com.qa.kittens.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.kittens.data.Kitten;
import com.qa.kittens.data.repos.KittenRepo;

@SpringBootTest
@ActiveProfiles("test")
public class KittenServiceDBUnitTest {

	@Autowired // injects the actual service from the context
	private KittenServiceDB service;

	@MockBean // tells Spring to make a 'fake' KittenRepo that we can program
	private KittenRepo repo;

	@Test
	void testUpdate() {
		// GIVEN
		int id = 1;

		Kitten testKitten = new Kitten(id, "Xerxes", "Blue Persian", 8, 7); // returned by FindById
		Kitten testNewKitten = new Kitten(id, "Moggie", "Rex", 12, 8); // new cat data

		// WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(testKitten)); // dw about this for now tbh
		Mockito.when(this.repo.save(new Kitten(id, "Moggie", "Rex", 12, 8))).thenReturn(testNewKitten);

		Kitten actual = this.service.replaceKitten(id, testNewKitten);
		// THEN
		assertThat(actual).isEqualTo(testNewKitten);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(new Kitten(id, "Moggie", "Rex", 12, 8));
	}

	@Test
	void testDelete() {
		int id = 1;

		assertThat(this.service.deleteKitten(id)).isEqualTo("Deleted: " + id);
	}

}
