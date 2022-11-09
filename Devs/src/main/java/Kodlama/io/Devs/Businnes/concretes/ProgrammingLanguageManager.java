package Kodlama.io.Devs.Businnes.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.Businnes.Abstracts.IProgrammingLanguageService;
import Kodlama.io.Devs.Businnes.Requests.ProgrammingLanguageRequest.ProgrammingLanguageRequest;
import Kodlama.io.Devs.Businnes.Responses.ProgrammingLanguageResponse.ProgrammingLanguageResponse;
import Kodlama.io.Devs.DataAccess.Abstracts.IProgrammingLanguageRepository;
import Kodlama.io.Devs.Entity.Concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements IProgrammingLanguageService {
	
	private IProgrammingLanguageRepository programmingLanguageRepository ;
	
	@Autowired
	public ProgrammingLanguageManager(IProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	private boolean isIdExist(int Id) {
		for(ProgrammingLanguage obje :programmingLanguageRepository.findAll()) {
			if(obje.getId()==Id) {
				return true;
			}
		}
		return false;
	}
	
	public  boolean isNameExist(String name) {
		for(ProgrammingLanguage obje :programmingLanguageRepository.findAll()) {
			if(obje.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNameBlank(String name) {
		return name.isBlank();
	}


	@Override
	public List<ProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguageResponse> listResponse = new ArrayList<ProgrammingLanguageResponse>() ;
		for(ProgrammingLanguage obje:programmingLanguageRepository.findAll()) {
			listResponse.add(new ProgrammingLanguageResponse(obje.getId(),obje.getName()));
		}
		
		return listResponse;
	}


	@Override
	public ProgrammingLanguageResponse getProgrammingLanguageById(int programmingLanguageId) throws Exception {
		if(!isIdExist(programmingLanguageId)) {
			throw new Exception("Girilen :"+ programmingLanguageId +" Id bulunamadı !");
		}
		ProgrammingLanguageResponse programmingLanguageResponse=new ProgrammingLanguageResponse();
		
		programmingLanguageResponse.setId(
				programmingLanguageRepository.getProgrammingLanguageById(programmingLanguageId).getId());
		
		programmingLanguageResponse.setName(
				programmingLanguageRepository.getProgrammingLanguageById(programmingLanguageId).getName());
		
		return programmingLanguageResponse; 
	}


	@Override
	public void add(ProgrammingLanguageRequest createProgrammingLanguage) throws Exception {

		if(isNameBlank(createProgrammingLanguage.getName())) {throw new Exception("Boş isim ile Ekleme Yapılamaz !");}
		if(isNameExist(createProgrammingLanguage.getName())) {throw new Exception(createProgrammingLanguage.getName()+" Tekrar Eklenemez !");}
		
		ProgrammingLanguage programmingLanguage =new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguage.getName());
		
		programmingLanguageRepository.save(programmingLanguage);
	}


	@Override
	public void delete(int ProgrammingLanguageId) throws Exception {
		if(!isIdExist(ProgrammingLanguageId)) {throw new Exception("Var olmayan :"+ProgrammingLanguageId +" Id ile silme işlemi Yapamazsınız !");}
		programmingLanguageRepository.deleteById(ProgrammingLanguageId);
	}


	@Override
	public void update(ProgrammingLanguageRequest programmingLanguageRequest)throws Exception {
		if(!isIdExist(programmingLanguageRequest.getId())) {
			throw new Exception("Güncellenmeye çalıştığınız :"+programmingLanguageRequest.getId()+" Id Bulunamadı !");}
		
		if(isNameBlank(programmingLanguageRequest.getName())) {
			throw new Exception("Boş isim ile Ekleme Yapılamaz !");}
		
		// Optional JPA 'tarafından kullanılması gerektiği için yazıldı. Doğru kullanımın bu olduğu söylendi.Ömer hoca, Hanifi Hoca
		 Optional<ProgrammingLanguage> programmingLanguage =programmingLanguageRepository.findById(programmingLanguageRequest.getId());
		 programmingLanguage.get().setName(programmingLanguageRequest.getName());
		 

			
		programmingLanguageRepository.save(programmingLanguage.get());	
	}


	

}
