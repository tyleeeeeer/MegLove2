package com.example.demo.controller;

import com.example.demo.domain.Mob;
import com.example.demo.service.MobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mobs")
public class MobController {
    @Autowired
    private MobService mobService;

    @GetMapping()
    public String index(Model model){
        List<Mob> mobs= mobService.findAll();
        model.addAttribute("mobs",mobs);
        return "mobs/index";
    }

    @GetMapping("new")
    public String newMob(Model model){
        return "mobs/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Mob mob = mobService.findOne(id);
        model.addAttribute("mob",mob);
        return "mobs/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model){
        Mob mob = mobService.findOne(id);
        model.addAttribute("mob",mob);
        return "mobs/show";
    }
    //create
    @PostMapping
    public String create(@ModelAttribute Mob mob){
        mobService.save(mob);
        return "redirect:/mobs";
    }
    @GetMapping("{id}/happy")
    public String happy(@PathVariable Long id, Model model){
        Mob mob = mobService.findOne(id);
        model.addAttribute("mob", mob);
        return "mobs/happy";
    }

    @GetMapping("{id}/bad")
    public String bad(@PathVariable Long id, Model model){
        Mob mob = mobService.findOne(id);
        model.addAttribute("mob",mob);
        return "mobs/bad";
    }
}
