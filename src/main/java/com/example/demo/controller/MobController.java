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
    @GetMapping("{id}/2/happy")
    public String happy1(@PathVariable Long id, Model model){
        Mob mob = mobService.findOne(id);
        model.addAttribute("mob", mob);
        mob.koukando += 50;
        mob.message = "楽しくお花を摘んで好感度があがった";
        return "mobs/show2";
    }

    @GetMapping("{id}/2/bad")
    public String bad1(@PathVariable Long id, Model model){
        Mob mob = mobService.findOne(id);
        model.addAttribute("mob",mob);
        mob.message = "めぐちゃん「匂いフェチとかキモっ」好感度が下がった";
        mob.koukando -= 50;

        return "mobs/show2";
    }

    @GetMapping("{id}/3/happy")
    public String happy2(@PathVariable Long id, Model model){
        Mob mob = mobService.findOne(id);
        model.addAttribute("mob", mob);
        Mob.koukando += 50;
        mob.message = "めぐちゃん「（ちょっとキュンとした）」好感度が上がった";
        return "mobs/show3";
    }

    @GetMapping("{id}/3/bad")
    public String bad2(@PathVariable Long id, Model model){
        Mob mob = mobService.findOne(id);
        model.addAttribute("mob",mob);
        mob.message = "めぐちゃん「（この人私ばっか見てキモ。。。運転しろよ）」好感度が下がった";
        Mob.koukando -= 50;

        return "mobs/show3";
    }

    @GetMapping("{id}/ending/happy")
    public String happy3(@PathVariable Long id, Model model){
        Mob mob = mobService.findOne(id);
        model.addAttribute("mob", mob);
        Mob.koukando += 50;
        if (Mob.koukando == 150) {
            Mob.koukando = 0;
            return "mobs/ending";
        } else if (Mob.koukando == -150) {
            Mob.koukando = 0;
            return "mobs/ending3";
        } else {
            Mob.koukando = 0;
            return "mobs/ending2";
        }

    }

    @GetMapping("{id}/ending/bad")
    public String bad3(@PathVariable Long id, Model model){
        Mob mob = mobService.findOne(id);
        model.addAttribute("mob",mob);
        Mob.koukando -= 50;

        if (Mob.koukando == 150) {
            Mob.koukando = 0;
            return "mobs/ending";
        } else if (Mob.koukando == -150) {
            Mob.koukando = 0;
            return "mobs/ending3";
        } else {
            Mob.koukando = 0;
            return "mobs/ending2";
        }
    }






}
