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
import Kodlama.io.Devs.Businnes.Requests.ProgrammingLanguageRequest.ProgrammingLanguageRequest;
import Kodlama.io.Devs.Businnes.Responses.ProgrammingLanguageResponse.ProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/ProgrammingLanguages")

public class ProgrammingLanguagesController {
	
	private IProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(IProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguageResponse> getAll() {
		return programmingLanguageService.getAll();
	}

	@GetMapping("/getById/{id}")
	public ProgrammingLanguageResponse getProgrammingLanguageById(@PathVariable("id") int programmingLanguageId) throws Exception {
		return programmingLanguageService.getProgrammingLanguageById(programmingLanguageId);
	}

	@PostMapping("/add")
	public void addProgrammingLanguage(@RequestBody ProgrammingLanguageRequest programmingLanguage) throws Exception {		
		 programmingLanguageService.add(programmingLanguage);
	}
	
	@DeleteMapping("/delete/{id}") 
	public void deleteProgrammingLanguageById(@PathVariable("id") int ProgrammingLanguageId) throws Exception {
		programmingLanguageService.delete(ProgrammingLanguageId);
	}

	@PutMapping("/update")
	public void updateProgrammingLanguage( @RequestBody ProgrammingLanguageRequest programmingLanguage) throws Exception {
	
		programmingLanguageService.update( programmingLanguage);
	}
	
	
}
