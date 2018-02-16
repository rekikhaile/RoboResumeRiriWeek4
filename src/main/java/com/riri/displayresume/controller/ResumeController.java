package com.riri.displayresume.controller;

import com.riri.displayresume.model.*;
import com.riri.displayresume.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ResumeController {
    @Autowired
    PersonalRepo personalRepo;
    @Autowired
    EduRepo eduRepo;
   @Autowired
    ExperienceRepo experienceRepo;
    @Autowired
    SkillRepo skillRepo;
    @Autowired
    SummaryRepo summaryRepo;
    @Autowired
    ReferenceRepo refRepo;
    @Autowired
    ViewRepo viewRepo;


    @RequestMapping("/")
    public String listpersonal(Model model) {
        return "index";
    }

    @RequestMapping("/index")
    public String homepersonal(Model model) {
        return "index";
    }

    @GetMapping("/addpersonal")
    public String personalForm(Model model){
        model.addAttribute("personal",new Personal());
        return "personalform";
    }

    @PostMapping("/postpersonal")
    public String processPersonalForm(@Valid @ModelAttribute("personal") Personal personal,
                                      BindingResult result){
        if(result.hasErrors()){
            return "personalform";
        }
        personalRepo.save(personal);
        return "redirect:/addeducation";

    }
    @GetMapping("/addeducation")
    public String educationForm(Model model){
        model.addAttribute("education",new Education());
        return "educationform";
    }

    @PostMapping("/posteducation")
    public String processEducationForm(@Valid @ModelAttribute("education") Education education,
                                       BindingResult result){
        if(result.hasErrors()){
            return "educationform";
        }
        eduRepo.save(education);
        return "redirect:/addeducation";

    }

    @GetMapping("/addexperience")
    public String experienceForm(Model model){
        model.addAttribute("experience",new Experience());
        return "experienceform";
    }

    @PostMapping("/postexperience")
    public String processExperienceForm(@Valid @ModelAttribute("experience") Experience experience,
                                        BindingResult result){
        if(result.hasErrors()){
            return "experienceform";
        }
        experienceRepo.save(experience);
        return "redirect:/addexperience";

    }

    @GetMapping("/addskill")
    public String skillForm(Model model){
        model.addAttribute("skill",new Skill());
        return "skillform";
}

    @PostMapping("/postskill")
    public String processSkillForm(@Valid @ModelAttribute("skill") Skill skill,
                                        BindingResult result){
        if(result.hasErrors()){
            return "skillform";
        }
        skillRepo.save(skill);
        return "redirect:/addskill";

    }


    @GetMapping("/addsummary")
    public String summaryForm(Model model){
        model.addAttribute("summary",new Summary());
        return "summary";
    }

    @PostMapping("/addsummary")
    public String processSummaryForm(@Valid @ModelAttribute("summary") Summary summary,
                                   BindingResult result){
        if(result.hasErrors()){
            return "summary";
        }
        summaryRepo.save(summary);
        return "redirect:/addpersonal";

    }


    @GetMapping("/addreference")
    public String referenceForm(Model model){
        model.addAttribute("reference",new Reference());
        return "referenceform";
    }

    @PostMapping("/addreference")
    public String processRefForm(@Valid @ModelAttribute("reference") Reference reference,
                                   BindingResult result){
        if(result.hasErrors()){
            return "referenceform";
        }
        refRepo.save(reference);
        return "redirect:/addreference";

    }

    @GetMapping("/addview")
    public String viewForm(Model model){
        model.addAttribute("skill",new View());
        return "viewform";
    }

    @PostMapping("/addview")
    public String processViewForm(@Valid @ModelAttribute("view") View view,
                                   BindingResult result){
        if(result.hasErrors()){
            return "viewform";
        }
       viewRepo.save(view);
        return "redirect:/addview";

    }
    @GetMapping("/displayresume")
    public String displayResume(Model model){
        model.addAttribute("summaries", summaryRepo.findAll());
        model.addAttribute("personals", personalRepo.findAll());
        model.addAttribute("educations", eduRepo.findAll());
        model.addAttribute("skills", skillRepo.findAll());
        model.addAttribute("experiences", experienceRepo.findAll());
        model.addAttribute("references",refRepo.findAll());

//        return "printresume";
        return "viewform";
    }

}
