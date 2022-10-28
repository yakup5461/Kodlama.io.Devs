package Kodlama.io.Devs.Businnes.Abstracts;

import java.util.List;

import Kodlama.io.Devs.Entity.Concretes.ProgrammingLanguage;

public interface IProgrammingLanguageService {
	
	List<ProgrammingLanguage> getAll( );
	
	ProgrammingLanguage getProgrammingLanguageById(int ProgrammingLanguageId);
	
	ProgrammingLanguage addProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception;
	
	void deleteProgrammingLanguageById(int ProgrammingLanguageId);
	
	ProgrammingLanguage updateProgrammingLanguage(int ProgrammingLanguageId , ProgrammingLanguage programmingLanguage);

}
