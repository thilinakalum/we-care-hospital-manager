package lk.wecare.doctor.channel.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.wecare.doctor.channel.security.entities.User;

/** @author Kavish Manjitha Perera */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findOneByUsername(String username);
}
