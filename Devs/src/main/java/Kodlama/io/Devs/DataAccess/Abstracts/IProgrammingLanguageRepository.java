package Kodlama.io.Devs.DataAccess.Abstracts;

import java.util.List;

import Kodlama.io.Devs.Entity.Concretes.ProgrammingLanguage;

public interface IProgrammingLanguageRepository {

	List<ProgrammingLanguage> getAll( ) ;
	
	ProgrammingLanguage getProgrammingLanguageById(int programmingLanguageId);
	
	void addProgrammingLanguage (ProgrammingLanguage programmingLanguage) ;
	
	void deleteProgrammingLanguageById(int ProgrammingLanguageId);
	
	void updateProgrammingLanguage(ProgrammingLanguage programmingLanguage);
	
	
}
