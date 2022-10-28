package Kodlama.io.Devs.DataAccess.Abstracts;

import java.util.List;

import Kodlama.io.Devs.Entity.Concretes.ProgrammingLanguage;

public interface IProgrammingLanguageRepository {

	List<ProgrammingLanguage> getAll( ) ;
	
	ProgrammingLanguage getProgrammingLanguageById(int programmingLanguageId);
	
	ProgrammingLanguage addProgrammingLanguage (ProgrammingLanguage programmingLanguage) throws Exception;
	
	void deleteProgrammingLanguageById(int ProgrammingLanguageId);
	
	ProgrammingLanguage updateProgrammingLanguage(int Id , ProgrammingLanguage programmingLanguage);
	
	
}
