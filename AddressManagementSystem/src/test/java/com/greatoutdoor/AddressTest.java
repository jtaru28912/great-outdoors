package com.greatoutdoor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.greatoutdoor.dao.AddressDao;
import com.greatoutdoor.entity.Address;
import com.greatoutdoor.exception.AddressException;
//testing Crud operations
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AddressTest {
	//DI
	@Autowired
	private AddressDao repo;
	//Test add
	@Test
	public void testAddAddress() {
		Address a = new Address(1, "Arihant Sales, 606","main road", "Garha phatak","Jabalpur","MP","482002");
		Address saved=repo.save(a);
		assertNotNull(saved);
	}
	//test find by id
	@Test
	public void testFindAddress() throws AddressException {
		long id = 1;
		Address addr = repo.findById(id).orElseThrow(()->new AddressException("Id not found"));
		assertThat(addr.getAddressId()).isEqualTo(id);
	}
	//test update
	@Test
	public void testUpdateAddress() throws AddressException {
		long id = 1;
		Address addr = new Address(id, "2333","505","Ranital","Main Road","Jabalpur","Mp");
		addr.setBuildingNo("404");
		Address update = repo.findById(id).orElseThrow(()->new AddressException("No id exist"));
		assertThat(update.getAddressId()).isEqualTo(id);
	}
	//testing all lists
	@Test
	public void testListOfAddress() {
		List<Address> addr = (List<Address>)repo.findAll();
		for (Address a: addr){
			System.out.println(a);
		}
		assertThat(addr).size().isGreaterThan(0);
	}
	//delete address testing
	@Test
	public void testDeleteAddress() {
		long id = 1;
		boolean present= repo.findById(id).isPresent();
		repo.deleteById(id);
		boolean notpresent= repo.findById(id).isPresent();
		assertTrue(present);
		assertFalse(notpresent);
		
	}
}
