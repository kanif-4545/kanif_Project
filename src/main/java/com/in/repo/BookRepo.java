package com.in.repo;

import org.springframework.data.repository.CrudRepository;
import com.in.entiry.*;

public interface BookRepo extends CrudRepository<Book, Integer>{
	

}
