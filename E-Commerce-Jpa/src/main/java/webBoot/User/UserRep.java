package webBoot.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
	
	
}
