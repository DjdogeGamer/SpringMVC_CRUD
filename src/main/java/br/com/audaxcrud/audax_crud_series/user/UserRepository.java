package br.com.audaxcrud.audax_crud_series.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
    UserEntity findByLogin(String username);
}
