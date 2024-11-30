package org.duckdns.ja2pyc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.duckdns.dto.SampleDTO;
import org.duckdns.dto.SampleListDTO;
import org.duckdns.dto.TodoDTO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/ex/*")
@Controller
@Log4j2
public class SampleController {
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		System.out.println("ex01 : " + dto);
		return "/ex/ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String userName, @RequestParam int age,
			@RequestParam("test") String testValue, Model model) {
		System.out.println("ex02 : name > " + userName + ", age > " + age);
		model.addAttribute("testName", userName);
		model.addAttribute("age", age);
		model.addAttribute("test", testValue);
		return "/ex/ex02";
	}

	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("lists") ArrayList<String> listsArr) {
		System.out.println("ex02List : " + listsArr);
		return "/ex/ex02List";
	}

	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleListDTO dto) {

		return "/ex/ex02Bean";
	}

	@InitBinder
	public void exInitBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));

	}

	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		System.out.println("todo : " + todo);
		return "/ex/ex03";
	}

	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, Model model) {
		System.out.println("ex04 : " + dto);
		model.addAttribute("dto", dto);
		return "/ex/ex04";
	}

	@GetMapping("/exRedirect")
	public String exRedirect(SampleDTO dto, Model model, RedirectAttributes rttr) {
		System.out.println("exRedirect");

		rttr.addFlashAttribute("modelkey", "modelvalue(rttr)");
		rttr.addAttribute("nonflash", "nonflashvalue(rttr)");
		model.addAttribute("modelkey", "modelvalue(model)");
		// rttr.addFlashAttribute("dto", dto);
		return "redirect:/sample/exTarget";
	}

	@GetMapping("/exTarget")
	// public String exTarget(SampleDTO dto) {
	public String exTarget(Model model, HttpServletRequest request) {
		System.out.println("exTarget");
		// System.out.println("dto : " + dto);

		Map md = model.asMap();
		for (Object modelKey : md.keySet()) {
			Object modelValue = md.get(modelKey);
			System.out.println(modelKey + " -- " + modelValue);
		}

		System.out.println("=== Request data ===");

		java.util.Enumeration<String> reqEnum = request.getParameterNames();
		while (reqEnum.hasMoreElements()) {
			String s = reqEnum.nextElement();
			System.out.println(s);
			System.out.println("==" + request.getParameter(s));
		}
		return "/ex/exTarget";
	}

	@GetMapping("/ex05")
	public void ex05() {
		System.out.println("ex05");
	}

	@GetMapping("/exSampleDTO")
	public @ResponseBody ArrayList<SampleDTO> exSampleDTO() {
		ArrayList<SampleDTO> dtoList = new ArrayList<>();
		SampleDTO dto1 = new SampleDTO();
		dto1.setName("DTO 1");
		dto1.setAge(21);
		log.info(dto1);
		dtoList.add(dto1);
		
		SampleDTO dto2 = new SampleDTO();
		dto2.setName("DTO 2");
		dto2.setAge(22);
		log.info(dto2);
		dtoList.add(dto2);
		return dtoList;
	}
	
	@GetMapping("/exResponseEntity")
	public ResponseEntity<SampleDTO> elResponseEntity() {
		SampleDTO dto1 = new SampleDTO();
		dto1.setName("Name");
		dto1.setAge(20);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json; charset=UTF-8");
		
		ResponseEntity<SampleDTO> responseEntity = new ResponseEntity<>(dto1, header, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/exUpload")
	public String exUpload() {
		return "/ex/exUpload";
	}
	
	@PostMapping("/exUploadPost")
	public String exUploadPost (ArrayList<MultipartFile> files) {
		for (MultipartFile file: files) {
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());
		}
		
		return "/ex/exUpload";	
	}
}
