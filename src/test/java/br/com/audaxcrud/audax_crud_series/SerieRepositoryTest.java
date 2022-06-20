package br.com.audaxcrud.audax_crud_series;

import br.com.audaxcrud.audax_crud_series.serie.Serie;
import br.com.audaxcrud.audax_crud_series.serie.SerieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class SerieRepositoryTest {
    @Autowired private SerieRepository repo;

    @Test
    public void testAddNewSerie() {
        Serie serie = new Serie();
        serie.setTitle("Title Test");
        serie.setDescription("Description Test");

        Serie savedSerie = repo.save(serie);

        Assertions.assertThat(savedSerie).isNotNull();
        Assertions.assertThat(savedSerie.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllSeries() {
        Iterable<Serie> series = repo.findAll();
        Assertions.assertThat(series).hasSizeGreaterThan(0);

        for (Serie serie : series) {
            System.out.println(serie);
        }
    }

    @Test
    public void testUpdateSerie() {
        Integer serieId = 1;
        Optional<Serie> optionalSerie= repo.findById(serieId);
        Serie serie = optionalSerie.get();
        serie.setTitle("Test Title 2");
        repo.save(serie);

        Serie updatedSerie = repo.findById(serieId).get();
        Assertions.assertThat(updatedSerie.getTitle()).isEqualTo("Test Title 2");
    }

    @Test
    public void testGetSerie() {
        Integer serieId = 2;
        Optional<Serie> optionalSerie = repo.findById(serieId);
        Assertions.assertThat(optionalSerie).isPresent();
        System.out.println(optionalSerie.get());
    }

    @Test
    public void testeDeleteSerie() {
        Integer serieId = 2;
        repo.deleteById(serieId);

        Optional<Serie> optionalSerie = repo.findById(serieId);
        Assertions.assertThat(optionalSerie).isNotPresent();
    }


}
