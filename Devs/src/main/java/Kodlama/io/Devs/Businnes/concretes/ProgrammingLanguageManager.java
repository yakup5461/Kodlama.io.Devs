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

	private boolean isIdExist(int Id) {
		for(ProgrammingLanguage obje :programmingLanguageRepository.getAll()) {
			if(obje.getId()==Id) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNameExist(String name) {
		for(ProgrammingLanguage obje :programmingLanguageRepository.getAll()) {
			if(obje.getName()==name) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNameBlank(String name) {
		return name.isBlank();
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}


	@Override
	public ProgrammingLanguage getProgrammingLanguageById(int programmingLanguageId) throws Exception {
		if(!isIdExist(programmingLanguageId)) {
			throw new Exception("Girilen :"+ programmingLanguageId +" Id bulunamadı !");
		}
		return programmingLanguageRepository.getProgrammingLanguageById(programmingLanguageId);
	}


	@Override
	public void addProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception {
		if(isIdExist(programmingLanguage.getId())) {throw new Exception(programmingLanguage.getId()+" ile Ekleme Yapılamaz !"); }
		if(isNameBlank(programmingLanguage.getName())) {throw new Exception("Boş isim ile Ekleme Yapılamaz !");}
		if(isNameExist(programmingLanguage.getName())) {throw new Exception(programmingLanguage.getName()+" Tekrar Eklenemez !");}
		getAll().add(programmingLanguage);
	}


	@Override
	public void deleteProgrammingLanguageById(int ProgrammingLanguageId) throws Exception {
		if(!isIdExist(ProgrammingLanguageId)) {throw new Exception("Var olmayan :"+ProgrammingLanguageId +" Id ile silme işlemi Yapamazsınız !");}
		programmingLanguageRepository.deleteProgrammingLanguageById(ProgrammingLanguageId);
	}


	@Override
	public void updateProgrammingLanguage(ProgrammingLanguage programmingLanguage)throws Exception {
		if(!isIdExist(programmingLanguage.getId())) {throw new Exception("Grilen :"+programmingLanguage.getId()+" Id Bulunamadı !");}
		if(isNameBlank(programmingLanguage.getName())) {throw new Exception("Boş isim ile Ekleme Yapılamaz !");}
		programmingLanguageRepository. updateProgrammingLanguage(programmingLanguage);		
	}

	

}
