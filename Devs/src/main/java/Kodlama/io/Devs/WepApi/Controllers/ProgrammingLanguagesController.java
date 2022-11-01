package Kodlama.io.Devs.WepApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.Businnes.Abstracts.IProgrammingLanguageService;
import Kodlama.io.Devs.Entity.Concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/ProgrammingLanguages")
public class ProgrammingLanguagesController {
	
	private IProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(IProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();
	}

	@GetMapping("/{id}")
	public ProgrammingLanguage getProgrammingLanguageById(@PathVariable("id") int programmingLanguageId) throws Exception {
		return programmingLanguageService.getProgrammingLanguageById(programmingLanguageId);
	}

	@PostMapping
	public void addProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {		
		 programmingLanguageService.addProgrammingLanguage(programmingLanguage);
	}
	
	@DeleteMapping("/{id}") 
	public void deleteProgrammingLanguageById(@PathVariable("id") int ProgrammingLanguageId) throws Exception {
		programmingLanguageService.deleteProgrammingLanguageById(ProgrammingLanguageId);
	}

	@PutMapping
	public void updateProgrammingLanguage( @RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
	
		programmingLanguageService.updateProgrammingLanguage( programmingLanguage);
	}
	
	
}
