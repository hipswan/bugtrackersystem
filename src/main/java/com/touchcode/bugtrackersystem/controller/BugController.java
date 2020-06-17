package com.touchcode.bugtrackersystem.controller;

import java.text.ParseException;
import java.util.ArrayList;
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

import com.touchcode.bugtrackersystem.entity.BugLog;
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
	public String saveandupdatebugs(@ModelAttribute("bug") Bugs theBug) throws ParseException {
		if (!(theBug.getCategory().isEmpty() || theBug.getDescription().isEmpty() || theBug.getAddedBy().isEmpty())) {
			Date now = new Date();
			theBug.setDate(now);

			Bugs newBug = bugservice.save(theBug);
			System.out.println("The new Bugs is " + newBug.getId());
			BugLog buglog = new BugLog();
			buglog.saveBug(newBug);
			bugservice.saveBugLog(buglog);

			return "redirect:/bugs/list";
		} else {
			return "redirect:/bugs/showFormForAdd";
		}
	}

	@GetMapping("/showFormForAdd")
	public String bugcreationform(Model model) throws ParseException {
		Bugs bug = new Bugs();
		Date now = new Date();
		bug.setDate(now);
		model.addAttribute("bug", bug);
		return "bugs/form";

	}

	@GetMapping("/showFormForUpdate")
	public String bugupdateform(@RequestParam("bugId") int bugId, Model model) throws ParseException {
		Bugs bug = bugservice.findById(bugId);
		Date now = new Date();
		bug.setDate(now);
		model.addAttribute("bug", bug);
		return "bugs/form";

	}

	@GetMapping("/update")
	public String bugupdateform(@RequestParam int bugId, String status, Model model) {
		Bugs bug = bugservice.findById(bugId);
		bug.setStatus(status);
		BugLog buglog = new BugLog();
		buglog.saveBug(bug);
		bugservice.save(bug);
		bugservice.saveBugLog(buglog);
		return "redirect:/bugs/list";
	}

	@GetMapping("/delete")
	public String bugdelete(@RequestParam("bugId") int bugId) {
		bugservice.deleteById(bugId);
		return "redirect:/bugs/list";
	}

	@GetMapping("/log")
	public String buglog(@RequestParam int bugId, Model model) {
		System.out.println("Running history  method");
		List<BugLog> buglogs = bugservice.findLogFor(bugId);
//		List<Bugs> bugs = new ArrayList<>();
//		for (BugLog buglog : buglogs) {
//			bugs.add(buglog.givemeBug(buglog));
//		}
		model.addAttribute("bugs", buglogs);
		return "bugs/log";
	}

}
