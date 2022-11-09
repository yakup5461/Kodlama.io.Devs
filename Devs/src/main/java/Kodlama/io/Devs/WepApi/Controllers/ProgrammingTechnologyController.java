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

import Kodlama.io.Devs.Businnes.Abstracts.IProgrammingTechnologyService;
import Kodlama.io.Devs.Businnes.Requests.ProgrammingTechnologyRequest.ProgrammingTechnologyRequest;
import Kodlama.io.Devs.Businnes.Responses.ProgrammingTechnologyResponse.ProgrammingTechnologyResponse;

@RestController
@RequestMapping("/api/ProgrammingTechnology")
public class ProgrammingTechnologyController {
	
	private final IProgrammingTechnologyService programmingTechnologyService ;
	
	@Autowired
	public ProgrammingTechnologyController(IProgrammingTechnologyService programmingTechnologyService ) {
		
		this.programmingTechnologyService = programmingTechnologyService;
	
	}
	
	@GetMapping("/getall")
	public List<ProgrammingTechnologyResponse> getAll() {
		return programmingTechnologyService.getAll();
	}

	@GetMapping("/getById/{id}")
	public ProgrammingTechnologyResponse getProgrammingTechnologyById(@PathVariable("id") int programmingTechnologyId) throws Exception {
		return programmingTechnologyService.getById(programmingTechnologyId);
	}

	@PostMapping("/add")
	public void addProgrammingTechnology(@RequestBody ProgrammingTechnologyRequest ProgrammingTechnologyRequest) throws Exception {		
		 programmingTechnologyService.add(ProgrammingTechnologyRequest);
	}
	
	@DeleteMapping("/delete/{id}") 
	public void deleteProgrammingTechnologyId(@PathVariable("id") int programmingTechnologyId) throws Exception {
		programmingTechnologyService.delete(programmingTechnologyId);
	}

	@PutMapping("/update")
	public void updateProgrammingTechnology( @RequestBody ProgrammingTechnologyRequest ProgrammingTechnologyRequest) throws Exception {
	
		programmingTechnologyService.update( ProgrammingTechnologyRequest.getId(),ProgrammingTechnologyRequest);
	}
	
	
}
