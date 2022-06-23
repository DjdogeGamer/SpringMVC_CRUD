package br.com.audaxcrud.audax_crud_series.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = ur.findByLogin(name);

        if(user == null) {
            throw new UsernameNotFoundException("Usuario nao encontrado");
        }
        return user;
    }
}
