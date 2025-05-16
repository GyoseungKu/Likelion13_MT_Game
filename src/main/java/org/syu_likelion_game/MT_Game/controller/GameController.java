package org.syu_likelion_game.MT_Game.controller;

import org.syu_likelion_game.MT_Game.model.GameData;
import jakarta.servlet.http.HttpSession;
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

    @PostMapping("/start")
    public String startGame(@RequestParam String category,
                            @RequestParam int duration,
                            @RequestParam int passCount,
                            HttpSession session,
                            Model model) {
        session.setAttribute("category", category);
        session.setAttribute("score", 0);
        session.setAttribute("startTime", System.currentTimeMillis());
        session.setAttribute("duration", duration);
        session.setAttribute("passCount", passCount);

        model.addAttribute("category", category);
        model.addAttribute("duration", duration);
        model.addAttribute("word", GameData.getRandomWord(category));
        model.addAttribute("score", 0);
        model.addAttribute("passCount", passCount);

        return "game";
    }

    @PostMapping("/pass")
    @ResponseBody
    public String passWord(HttpSession session) {
        Integer passCount = (Integer) session.getAttribute("passCount");
        if (passCount == null) passCount = 0;
        passCount--;
        session.setAttribute("passCount", passCount);

        if (passCount < 0) {
            return "END";
        } else {
            String category = (String) session.getAttribute("category");
            return GameData.getRandomWord(category);
        }
    }

    @PostMapping("/next")
    @ResponseBody
    public String nextWord(HttpSession session) {
        String category = (String) session.getAttribute("category");
        return GameData.getRandomWord(category);
    }

    @PostMapping("/score")
    @ResponseBody
    public int updateScore(HttpSession session) {
        int score = (int) session.getAttribute("score");
        score++;
        session.setAttribute("score", score);
        return score;
    }

    @GetMapping("/result")
    public String result(HttpSession session, Model model) {
        int score = (int) session.getAttribute("score");
        String category = (String) session.getAttribute("category");
        model.addAttribute("score", score);
        model.addAttribute("category", category);
        session.invalidate();
        return "result";
    }
}
