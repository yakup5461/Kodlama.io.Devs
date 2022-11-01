package Kodlama.io.Devs.Businnes.Abstracts;

import java.util.List;

import Kodlama.io.Devs.Entity.Concretes.ProgrammingLanguage;

public interface IProgrammingLanguageService {
	
	List<ProgrammingLanguage> getAll( );
	
	ProgrammingLanguage getProgrammingLanguageById(int ProgrammingLanguageId) throws Exception;
	
	void addProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception;
	
	void deleteProgrammingLanguageById(int ProgrammingLanguageId) throws Exception;
	
	void updateProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception;

}
