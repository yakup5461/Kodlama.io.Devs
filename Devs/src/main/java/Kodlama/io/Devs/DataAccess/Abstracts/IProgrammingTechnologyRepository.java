package Kodlama.io.Devs.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.Entity.Concretes.ProgrammingTechnology;


public interface IProgrammingTechnologyRepository extends JpaRepository<ProgrammingTechnology , Integer>{
	
}
