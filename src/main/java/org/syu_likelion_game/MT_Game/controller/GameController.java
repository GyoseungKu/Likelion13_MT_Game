package org.syu_likelion_game.MT_Game.controller;

import org.syu_likelion_game.MT_Game.model.GameData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("categories", GameData.getCategories());
        return "index";
    }

    @PostMapping("/play")
    public String play(@RequestParam String category, Model model) {
        String word = GameData.getRandomWord(category);
        model.addAttribute("selectedCategory", category);
        model.addAttribute("word", word);
        model.addAttribute("categories", GameData.getCategories());
        return "index";
    }
}