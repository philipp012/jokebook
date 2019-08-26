package ch.bbw.jokebook.controller;

import ch.bbw.jokebook.service.DatabaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class MainController {

	
	@GetMapping("/")
	public String homepage(Model model) throws SQLException, ClassNotFoundException {
		DatabaseService databaseService = new DatabaseService();
		model.addAttribute("jokeList", databaseService.getJokes());
		return "index";
	}
	
	@PostMapping("/")
	public void deleteJoke(@RequestParam(required = true) String id) {
		System.out.println("delete Joke: " + id);
	}
}
