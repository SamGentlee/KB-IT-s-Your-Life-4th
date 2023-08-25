package com.mulcam.kb04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/* 구구단 출력 서비스*/
@Controller
public class GugudanController {
	
	@GetMapping("/gugudan")
	public String gugudan() {
		
		return "gugudan/gugudan_form";
	}
	
	@GetMapping("/gugudan_view")
	public String gugudan_view(@RequestParam(value = "gugudanNum") int gugudanNum
		,@RequestParam(value = "gugudanNum2", defaultValue = "0") int gugudanNum2 
		,Model model	) {
		//view 출력은 jsp에서 하는것을 추천
		String result = "";
		for(int i=1;i<=9;i++) {
			result+=gugudanNum2+"x"+i+"="+gugudanNum2*i+"<br>";
		}
		
		model.addAttribute("gugudanNum",gugudanNum);
		model.addAttribute("result", result);
		return "gugudan/gugudan_form";
	}
}
