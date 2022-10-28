package Kodlama.io.Devs.DataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.DataAccess.Abstracts.IProgrammingLanguageRepository;
import Kodlama.io.Devs.Entity.Concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguagesRepository implements IProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages ;
	
	//constructor parametresiz
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
// Varsa Programlama dilinin Id sini getirecek yoksa listedeki ID getirecek.Bilerek Throw eklemedim.
		int objIndex=0;
		for (ProgrammingLanguage obje : programmingLanguages) {
			if (obje.getId()==programmingLanguageId) {
			objIndex=programmingLanguages.indexOf(obje);
			return programmingLanguages.get(objIndex);
			}
					
			
		}
		return programmingLanguages.get(programmingLanguageId);
	}

	@Override
	public ProgrammingLanguage addProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception {
		
		for (ProgrammingLanguage obje : programmingLanguages) {
			if (obje.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Aynı isimde programlama dili tekrar eklenemez !");
			}
		}
		programmingLanguages.add(programmingLanguage);
		System.out.println(programmingLanguage.getName()+" Programlama Dili "+
						   programmingLanguages.indexOf(programmingLanguage)+"index'e Eklendi.");
		
		return programmingLanguage ;
	}

	@Override
	public void deleteProgrammingLanguageById(int ProgrammingLanguageId) {
		
		programmingLanguages.remove(ProgrammingLanguageId);
	}

	@Override
	public ProgrammingLanguage updateProgrammingLanguage(int Id, ProgrammingLanguage programmingLanguage) {
		
		programmingLanguages.set(Id,programmingLanguage);
		
		return programmingLanguage;
	}

	
	
}
