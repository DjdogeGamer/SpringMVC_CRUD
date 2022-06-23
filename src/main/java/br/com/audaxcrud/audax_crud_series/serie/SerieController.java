package br.com.audaxcrud.audax_crud_series.serie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Controller
public class SerieController {
    @Autowired private SerieService service;

    @GetMapping("/series")
    public String showSerieList(Model model) {
        List<Serie> listSeries = service.listAll();
        model.addAttribute("listSeries", listSeries);
        return "series";
    }

    @GetMapping("/series/adicionar")
    public String showNewSerieForm(Model model) {
        model.addAttribute("serie", new Serie());
        model.addAttribute("pageTitle", "Adicionar Nova Série");
        return "serie_form";
    }

    @PostMapping("/series/save")
    public String saveSerie(Serie serie) {
        service.save(serie);
        return "redirect:/series";
    }

    @GetMapping("/series/editar/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) throws UserPrincipalNotFoundException {
        Serie serie = service.get(id);
        model.addAttribute("serie", serie);
        model.addAttribute("pageTitle, Editar Série (ID: "+ id + ")");

        return "serie_form";
    }

    @GetMapping("/series/excluir/{id}")
    public String deleteSerie(@PathVariable("id") Integer id, RedirectAttributes ra) {
        service.delete(id);
        return "redirect:/series";
    }

}
