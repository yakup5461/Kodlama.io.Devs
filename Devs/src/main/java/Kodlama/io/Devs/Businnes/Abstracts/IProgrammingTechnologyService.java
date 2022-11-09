package Kodlama.io.Devs.Businnes.Abstracts;

import java.util.List;

import Kodlama.io.Devs.Businnes.Requests.ProgrammingTechnologyRequest.ProgrammingTechnologyRequest;
import Kodlama.io.Devs.Businnes.Responses.ProgrammingTechnologyResponse.ProgrammingTechnologyResponse;

public interface IProgrammingTechnologyService {
	
	void add(ProgrammingTechnologyRequest programmingTechnologyRequest)throws Exception;
	void update(int id,ProgrammingTechnologyRequest programmingTechnologyRequest)throws Exception;
	void delete(int id)throws Exception;
	ProgrammingTechnologyResponse getById(int id)throws Exception;
	List<ProgrammingTechnologyResponse> getAll();

}
