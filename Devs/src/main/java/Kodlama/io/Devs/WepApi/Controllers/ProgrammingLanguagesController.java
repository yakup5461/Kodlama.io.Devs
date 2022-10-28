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

	@GetMapping("/{Id}")
	public ProgrammingLanguage getProgrammingLanguageById(@PathVariable("Id") int programmingLanguageId) {
		return programmingLanguageService.getProgrammingLanguageById(programmingLanguageId);
	}

	@PostMapping
	public ProgrammingLanguage addProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {		
		return programmingLanguageService.addProgrammingLanguage(programmingLanguage);
	}
	
	@DeleteMapping("Id")
	public void deleteProgrammingLanguageById(@PathVariable("Id") int ProgrammingLanguageId) {
		programmingLanguageService.deleteProgrammingLanguageById(ProgrammingLanguageId);
	}

	@PutMapping("Id")
	public ProgrammingLanguage updateProgrammingLanguage(@PathVariable("Id") int ProgrammingLanguageId, @RequestBody ProgrammingLanguage programmingLanguage) {
	
		return programmingLanguageService.updateProgrammingLanguage(ProgrammingLanguageId, programmingLanguage);
	}
	
	
}
