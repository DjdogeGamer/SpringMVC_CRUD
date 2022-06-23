package br.com.audaxcrud.audax_crud_series.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity userSerie = userRepository.findByLogin(username);
        UserDetails user = User.withUsername(userSerie.getUsername())
                .password(userSerie.getPassword())
                .authorities("USER").build();
        return user;
    }



}
