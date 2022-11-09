package Kodlama.io.Devs.Businnes.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.Businnes.Abstracts.IProgrammingLanguageService;
import Kodlama.io.Devs.Businnes.Abstracts.IProgrammingTechnologyService;
import Kodlama.io.Devs.Businnes.Requests.ProgrammingTechnologyRequest.ProgrammingTechnologyRequest;
import Kodlama.io.Devs.Businnes.Responses.ProgrammingLanguageResponse.ProgrammingLanguageResponse;
import Kodlama.io.Devs.Businnes.Responses.ProgrammingTechnologyResponse.ProgrammingTechnologyResponse;
import Kodlama.io.Devs.DataAccess.Abstracts.IProgrammingTechnologyRepository;
import Kodlama.io.Devs.Entity.Concretes.ProgrammingLanguage;
import Kodlama.io.Devs.Entity.Concretes.ProgrammingTechnology;

@Service
public class ProgrammingTechnologyManager implements IProgrammingTechnologyService  {
	
	private final IProgrammingTechnologyRepository programmingTechnologyRepository ;
	@Lazy private final IProgrammingLanguageService programmingLanguageService ;
	 
	public ProgrammingTechnologyManager(IProgrammingTechnologyRepository programmingTechnologyRepository,
			IProgrammingLanguageService programmingLanguageService) {
		
		this.programmingTechnologyRepository = programmingTechnologyRepository;
		this.programmingLanguageService = programmingLanguageService;
	}

	private boolean isIdExist(int Id) {
		for(ProgrammingTechnology obje :programmingTechnologyRepository.findAll()) {
			if(obje.getId()==Id) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNameExist(String name) {
		for(ProgrammingTechnology obje :programmingTechnologyRepository.findAll()) {
			if( obje.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	//Teknolojiye ait programlama dilinin varlığını kontrol eder.
	private boolean isTechnologyOfProgramLanguageExist(ProgrammingTechnologyRequest programmingTechnologyRequest) {
		for(ProgrammingLanguageResponse obje :programmingLanguageService.getAll()) {
			if(obje.getName().equalsIgnoreCase(programmingTechnologyRequest.getProgrammingLanguageNameOfTechnology())) {
				return true;
			}
		}
		return false;
	}
	private int IdOfProgrammingLanguageOfTechnology(String name) {
		for(ProgrammingLanguageResponse obje: this.programmingLanguageService.getAll()) {
			if(obje.getName().equalsIgnoreCase(name)) {
			return obje.getId();
			}
		}
		return Integer.MAX_VALUE;
	}
	
	private boolean isNameBlank(String name) {
		return name.isBlank();
	}
	
	@Override   
	public void add(ProgrammingTechnologyRequest programmingTechnologyRequest) throws Exception {
		
		if(isNameBlank(programmingTechnologyRequest.getName())) {throw new Exception("Boş isim ile Ekleme Yapılamaz !");}
		if(isNameExist(programmingTechnologyRequest.getName())) {throw new Exception("Bu İsimde :"+programmingTechnologyRequest.getName()+"Programlama Dili ekleyemezsin. ");}
		//Teknolojiye ait programlama dili yoksa hata fırlatır.
		if(!isTechnologyOfProgramLanguageExist(programmingTechnologyRequest)) {throw new Exception("Bu isimde : "+programmingTechnologyRequest.getProgrammingLanguageNameOfTechnology()+" bir programlama dili olmadığı için Ekleme Yapılamaz ! Lütfen Önce Programlama Dilini Ekleyiniz  !");}
		
		
		ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(IdOfProgrammingLanguageOfTechnology(programmingTechnologyRequest.getProgrammingLanguageNameOfTechnology()));
		programmingLanguage.setName(programmingTechnologyRequest.getProgrammingLanguageNameOfTechnology());
		
		programmingTechnology.setId(programmingTechnologyRequest.getId());
		programmingTechnology.setName(programmingTechnologyRequest.getName());
		programmingTechnology.setProgrammingLanguage(programmingLanguage);
		
		this.programmingTechnologyRepository.save(programmingTechnology);
		
	}

	@Override	
	public void update(int id, ProgrammingTechnologyRequest programmingTechnologyRequest)throws Exception {
		if(isNameBlank(programmingTechnologyRequest.getName())) {throw new Exception("Boş isim ile Ekleme Yapılamaz !");}
		if(isNameExist(programmingTechnologyRequest.getName())) {throw new Exception("Bu İsimde :"+programmingTechnologyRequest.getName()+"Programlama Dili ekleyemezsin. ");}
		//Teknolojiye ait programlama dili yoksa hata fırlatır.
		if(!isTechnologyOfProgramLanguageExist(programmingTechnologyRequest)) {throw new Exception("Bu isimde : "+programmingTechnologyRequest.getProgrammingLanguageNameOfTechnology()+" bir programlama dili olmadığı için Güncelleme Yapılamaz ! Lütfen Önce Programlama Dilini Ekleyiniz  !");}
				
		 Optional<ProgrammingTechnology> ProgrammingTechnologies=this.programmingTechnologyRepository.findById(id);
		 ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		 programmingLanguage.setId(IdOfProgrammingLanguageOfTechnology(programmingTechnologyRequest.getProgrammingLanguageNameOfTechnology()));
		 programmingLanguage.setName(programmingTechnologyRequest.getProgrammingLanguageNameOfTechnology());
	
		 ProgrammingTechnologies.get().setName(programmingTechnologyRequest.getName());
		 ProgrammingTechnologies.get().setProgrammingLanguage(programmingLanguage);
			
		 this.programmingTechnologyRepository.save(ProgrammingTechnologies.get());
	}

	@Override
	public void delete(int id) throws Exception {
		if(!isIdExist(id)) {throw new Exception("Var olmayan :"+id +" Id ile silme işlemi Yapamazsınız !");}
		this.programmingTechnologyRepository.deleteById(id);
		
	}

	@Override
	public ProgrammingTechnologyResponse getById(int id) throws Exception{
		
		if(!isIdExist(id)) {throw new Exception("Var olmayan :"+id +" Id ile getirme işlemi Yapamazsınız !");}
		
		ProgrammingTechnologyResponse programmingTechnologyResponse= new ProgrammingTechnologyResponse();		
		Optional<ProgrammingTechnology> programmingTechnologies=this.programmingTechnologyRepository.findById(id);
		programmingTechnologyResponse.setName(programmingTechnologies.get().getName());
		programmingTechnologyResponse.setId(programmingTechnologies.get().getId());
		return programmingTechnologyResponse ;
	}

	@Override
	public List<ProgrammingTechnologyResponse> getAll() {
		
		List<ProgrammingTechnology> programmingTechnologies = this.programmingTechnologyRepository.findAll() ;
		List<ProgrammingTechnologyResponse> programmingTechnologyResponses = new ArrayList<>();
		
		for(ProgrammingTechnology obje : programmingTechnologies) {
			programmingTechnologyResponses.add(new ProgrammingTechnologyResponse(obje.getId(),obje.getName()));
		}
		
	
		return programmingTechnologyResponses ;
	}
	

}
