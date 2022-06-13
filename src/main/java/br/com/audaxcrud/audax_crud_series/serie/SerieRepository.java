package br.com.audaxcrud.audax_crud_series.serie;

import org.springframework.data.repository.CrudRepository;

public interface SerieRepository extends CrudRepository<Serie,Integer> {
    public Long countById(Integer id);
}
