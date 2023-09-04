package mulcam.kb04.bootmvc0901.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(Model model,@RequestParam("name") String name) {
		model.addAttribute("name", name);
		model.addAttribute("msg", "반갑습니다");
		return "hello";
	}
}
