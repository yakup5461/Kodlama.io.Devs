package Kodlama.io.Devs.Businnes.Abstracts;

import java.util.List;

import Kodlama.io.Devs.Businnes.Requests.ProgrammingLanguageRequest.ProgrammingLanguageRequest;
import Kodlama.io.Devs.Businnes.Responses.ProgrammingLanguageResponse.ProgrammingLanguageResponse;

public interface IProgrammingLanguageService {

	void add( ProgrammingLanguageRequest createProgrammingLanguage ) throws Exception;
	void delete( int deleteProgrammingLanguageId ) throws Exception;
	void update( ProgrammingLanguageRequest programmingLanguageRequest ) throws Exception;
	
	List<ProgrammingLanguageResponse> getAll();
	
	ProgrammingLanguageResponse getProgrammingLanguageById(int id) throws Exception;
	
}
