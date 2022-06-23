package br.com.audaxcrud.audax_crud_series.serie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class SerieService {
    @Autowired private SerieRepository repo;

    public List<Serie> listAll() {
        return (List<Serie>) repo.findAll();
    }

    public void save(Serie serie) {
        repo.save(serie);

    }

    public Serie get(Integer id) throws UserPrincipalNotFoundException {
        Optional<Serie> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserPrincipalNotFoundException("Nenhuma Série com o ID: "+id);
    }

    public void delete(Integer id){
        Long count = repo.countById(id);
        if(count == null || count == 0){
            System.out.println("Não foi possível deletar a Série");
        }
        repo.deleteById(id);
    }
}
