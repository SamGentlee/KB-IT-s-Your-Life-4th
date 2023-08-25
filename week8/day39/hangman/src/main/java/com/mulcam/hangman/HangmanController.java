package com.mulcam.hangman;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HangmanController {
	
	private char[] alphabets={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private	String [] words={"ELEPHANT", "DOG", "TIGER", "BEAR", "CAMEL","DONKEY"};
	private String word = words[new java.util.Random().nextInt(words.length)];
	private char[] wordChar = word.toCharArray();
	
	
	@GetMapping("/hangman")
	public String hangman(Model model) {
		model.addAttribute("alphabets", alphabets);
		System.out.println(word);
		
		model.addAttribute("wordChar",wordChar);
		return "hangman/hangman";
	}
	
	@GetMapping("/hangman_click")
	public String hangman_click(@RequestParam(name="alpha") char alpha, Model model) {
		for(char c : wordChar) {
			if(c==alpha) {
				
			}
		}
		
		
		return "hangman/hangman";
	}
	
}
