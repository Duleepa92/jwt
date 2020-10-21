/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DAOUser;

/**
 * @author duleepa_w
 *
 */

@Repository
public interface UserRepository extends CrudRepository<DAOUser , Integer>{

	 DAOUser findByUsername(String username);
}
