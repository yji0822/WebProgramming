package com.lec.ch06;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*/ 가 있는지 확인하고 있다면 밑에 있는 함수 실행 
	 * locale : ko/kr이 자동적으로 들어가있을 것.*/

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		/* 데이트를 받아와서 SimpleDateFormat 식으로 한국 스타일로 연월일시간을 받아와서 출력하도록 하는 것.*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("greeting", "Hello, Spring!!! 안녕, 스프링!!!"); // 한글은 아직 깨지는 상태
		
		return "home"; // 컨트롤러에서 뷰(home)을 리턴해주도록 하는 것
		// model에는 serverTime이랑 greeting을 담아 놓은 상태
		// viewResolver 는 어디에 있을까? >> servlet-context.xml 
	}
	
}
