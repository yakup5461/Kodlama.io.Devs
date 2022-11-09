package Kodlama.io.Devs.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.Entity.Concretes.ProgrammingLanguage;


public interface IProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage , Integer>{

	ProgrammingLanguage getProgrammingLanguageById ( int  programmingLanguageId );
	ProgrammingLanguage getProgrammingLanguageByName ( String  programmingLanguageName ); 
	
	
	
	
}
