package Kodlama.io.Devs.Businnes.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.Businnes.Abstracts.IProgrammingLanguageService;
import Kodlama.io.Devs.DataAccess.Abstracts.IProgrammingLanguageRepository;
import Kodlama.io.Devs.Entity.Concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements IProgrammingLanguageService {
	
	private IProgrammingLanguageRepository programmingLanguageRepository ;
	
	
	@Autowired
	public ProgrammingLanguageManager(IProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getProgrammingLanguageById(int ProgrammingLanguageId) {
	
		return programmingLanguageRepository.getProgrammingLanguageById(ProgrammingLanguageId);
	}
	
	@Override
	public ProgrammingLanguage addProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception {
	
		return programmingLanguageRepository.addProgrammingLanguage(programmingLanguage);
	}

	@Override
	public void deleteProgrammingLanguageById(int ProgrammingLanguageId) {
		
		programmingLanguageRepository.deleteProgrammingLanguageById(ProgrammingLanguageId);
	}

	@Override
	public ProgrammingLanguage updateProgrammingLanguage(int Id, ProgrammingLanguage programmingLanguage) {
		
		return programmingLanguageRepository.updateProgrammingLanguage(Id, programmingLanguage);
	}


}
