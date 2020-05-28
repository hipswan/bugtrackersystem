package com.touchcode.bugtrackersystem.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.touchcode.bugtrackersystem.entity.Bugs;
import com.touchcode.bugtrackersystem.service.BugService;

@Controller
@RequestMapping("/bugs")
public class BugController {

	@Autowired
	private BugService bugservice;

	@GetMapping("/list")
	public String buglist(Model model) {

		List<Bugs> bugs = bugservice.findAll();
		model.addAttribute("bugs", bugs);
		return "bugs/list";

	}

	@PostMapping("/save")
	public String saveandupdatebugs(@ModelAttribute("bug") Bugs theBug) {
		theBug.setDate(new Date());
		System.out.println(theBug.getDate());
		bugservice.save(theBug);

		return "redirect:/bugs/list";

	}

	@GetMapping("/showFormForAdd")
	public String bugcreationform(Model model) {

		Bugs bug = new Bugs();
		bug.setDate(new Date());
		model.addAttribute("bug", bug);
		return "bugs/form";

	}

	@GetMapping("/showFormForUpdate")
	public String bugupdateform(@RequestParam("bugId") int bugId, Model model) {

		Bugs bug = bugservice.findById(bugId);
		bug.setDate(new Date());
		model.addAttribute("bug", bug);
		return "bugs/form";

	}

	@GetMapping("/update")
	public String bugupdateform(@RequestParam int bugId, String status, Model model) {
		
		Bugs bug = bugservice.findById(bugId);
		bug.setStatus(status);
		bugservice.save(bug);
		return "redirect:/bugs/list";

	}

	@GetMapping("/delete")
	public String bugdelete(@RequestParam("bugId") int bugId) {

		bugservice.deleteById(bugId);

		return "redirect:/bugs/list";

	}

}
