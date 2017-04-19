package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.BoardVO;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
	@GetMapping("/doA")
	public void doA(Model model){
		
		System.out.println("doA");
		
		BoardVO vo = new BoardVO();
		
		vo.setBno(12);
		vo.setTitle("하하");
		vo.setContent("히히");
		
		model.addAttribute("vo", vo);
		
		
	}
	
	
	
	
	
}
