package com.example.rama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rama.model.ClassActivities;
import com.example.rama.repository.ClassActivitiesRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/")
public class PageClassActivitiesController {

    @Autowired
    private ClassActivitiesRepository classActivitiesRepository;

    @GetMapping("/activities")
    public String listActivities(Model model){
        model.addAttribute("activity", classActivitiesRepository.findAll());
        return "list-activities";
    }

    @GetMapping("/nuevo")
    public String addNewForm(Model model){
        model.addAttribute("activity", new ClassActivities());
        return "new-activity-form";
    }

    @PostMapping("/nuevo")
    public String saveActivity(@ModelAttribute ClassActivities activity){
        classActivitiesRepository.save(activity);
        return "redirect:/activities";
    }

    @GetMapping("/editar/{id}")
    public String editActivityForm(Model model, @PathVariable Long id){
        ClassActivities activity = classActivitiesRepository.findById(id).get();
        model.addAttribute("activity",activity);
        return "new-activity-form";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteActivity(@PathVariable Long id){
        classActivitiesRepository.delete(new ClassActivities(id));
        return "redirect:/activities";
    }

}
