package com.mk.zzdats_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class BernudarzsController {

    @Autowired
    private BernudarzsService bernudarzsService;

    @Autowired
    private BernsService bernsService;

    @GetMapping(value = "/")
    public String showHelloPage() {
        return "main-menu";
    }

    @GetMapping("/bernudarzs/list")
    public String showList(Model model) {
        model.addAttribute("bernudarzsList", bernudarzsService.list());

        return "bernudarzs-list";
    }

    @GetMapping("/bernudarzs/rinda/{id}")
    public String showQueue(Model model, Berns berns, @PathVariable("id") Long id) {

        model.addAttribute("bernsQueue", bernudarzsService.getQueue(id));
        model.addAttribute("bernudarzs", bernudarzsService.getById(id));

        return "rinda";
    }

    @PostMapping("/bernudarzs/add/{id}")
    public String addToQueue(
            Model model,
            @Valid Berns berns,
            BindingResult bindingResult,
            @PathVariable("id") Long id
    ) {
        Bernudarzs bernudarzs = bernudarzsService.getById(id);

        if (bindingResult.hasErrors()) {
            model.addAttribute("bernudarzs", bernudarzsService.getById(id));
            return "berns-add";
        }

        berns.setAiznemtaRinda(bernudarzs);
        bernsService.save(berns);

        model.addAttribute("bernudarzsList", bernudarzsService.list());

        return "redirect:/bernudarzs/rinda/" + id.toString();
    }

    @GetMapping("/bernudarzs/add/{id}")
    public String addToQueueForm(Model model, Berns berns, @PathVariable("id") Long id) {

        model.addAttribute("bernudarzs", bernudarzsService.getById(id));

        return "berns-add";
    }

    @PostMapping("/bernudarzs/delete_from_queue/{id}")
    public String deleteByPk(Model model, Berns berns, @PathVariable("id") Long id) {
        Berns bernsToDelete = bernudarzsService.findByPk(berns.getPersCode(), id);
        if (bernsToDelete != null) {
            bernsService.delete(bernsToDelete);
        }

        return "redirect:/bernudarzs/rinda/" + id.toString();
    }
}
