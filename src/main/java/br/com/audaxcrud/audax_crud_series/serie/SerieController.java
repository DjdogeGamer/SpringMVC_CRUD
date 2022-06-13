package br.com.audaxcrud.audax_crud_series.serie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Controller
public class SerieController {
    @Autowired private SerieService service;

    @GetMapping("")
    public String showSerieList(Model model) {
        List<Serie> listSeries = service.listAll();
        model.addAttribute("listSeries", listSeries);
        return "index";
    }

    @GetMapping("/adicionar")
    public String showNewForm(Model model) {
        model.addAttribute("serie", new Serie());
        return "serie_form";
    }

    @PostMapping("/save")
    public String saveSerie(Serie serie) {
        service.save(serie);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        try {
            Serie serie = service.get(id);
            model.addAttribute("serie", serie);
            return "serie_form";
        } catch (UserPrincipalNotFoundException e) {
            e.printStackTrace();
            return "redirect:/";
        }
    }

    @GetMapping("/excluir/{id}")
    public String deleteSerie(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/";
    }
}
