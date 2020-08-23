package lk.wecare.doctor.channel.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lk.wecare.doctor.channel.security.dao.UserRepository;
import lk.wecare.doctor.channel.security.entities.User;

/** @author Kavish Manjitha Perera */
@Service
public class AppUserDetailsService implements UserDetailsService {

  @Autowired UserRepository userRepository;

  @Autowired private BCryptPasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findOneByUsername(username);
    return user;
  }

  public User save(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.saveAndFlush(user);
  }
}
