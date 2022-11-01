package Kodlama.io.Devs.DataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.DataAccess.Abstracts.IProgrammingLanguageRepository;
import Kodlama.io.Devs.Entity.Concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguagesRepository implements IProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages ;
	
	//velevki veritabanından geldim.
	public InMemoryProgrammingLanguagesRepository() {
		super();
		programmingLanguages= new ArrayList<ProgrammingLanguage>();	
		programmingLanguages.add( new ProgrammingLanguage(0,"Kotlin") ) ;
		programmingLanguages.add( new ProgrammingLanguage(1,"Java") ) ;
		programmingLanguages.add( new ProgrammingLanguage(2,"JavaScript") ) ;
		programmingLanguages.add( new ProgrammingLanguage(3,"Python") ) ;
		programmingLanguages.add( new ProgrammingLanguage(4,"C#") ) ;
		programmingLanguages.add( new ProgrammingLanguage(5,"HTML") ) ;
		programmingLanguages.add( new ProgrammingLanguage(6,"CSS3") ) ;
		programmingLanguages.add( new ProgrammingLanguage(7,"Perl") ) ;
		programmingLanguages.add( new ProgrammingLanguage(8,"Swift") ) ;
		programmingLanguages.add( new ProgrammingLanguage(9,"C++") ) ;	
		programmingLanguages.add( new ProgrammingLanguage(61,"Go") ) ;	
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getProgrammingLanguageById(int programmingLanguageId) {		
		for (ProgrammingLanguage programmingLanguage : getAll()) {
			if (programmingLanguage.getId()==programmingLanguageId) {
				return programmingLanguage ;
				}
			}
			return null ;
	}

	@Override
	public void addProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
		getAll().add(programmingLanguage);

	}

	@Override
	public void deleteProgrammingLanguageById(int programmingLanguageId) {
		getAll().remove(getProgrammingLanguageById(programmingLanguageId));
		
		//sildiği halde hata-exception fırlattığı için Yorum satırına aldım. yerine bunu yazdım.
		
//		for (ProgrammingLanguage programmingLanguage : getAll()) {
//			if (programmingLanguage.getId()==programmingLanguageId) {
//				programmingLanguages.remove(getProgrammingLanguageById(programmingLanguageId));
//				}
//			}
	}

	@Override
	public void updateProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
//		for (ProgrammingLanguage programmingLanguageObj : getAll()) {
//			if (programmingLanguageObj.getId()==Id) {
//			getAll().remove(programmingLanguageObj);
//			getAll().add(programmingLanguage);
//			}
//		}
	getProgrammingLanguageById(programmingLanguage.getId()).setName(programmingLanguage.getName()) ;	
	}

	
	
}
