package Kodlama.io.Devs.Entity.Concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="programming_technologies")
@Entity
public class ProgrammingTechnology {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "programming_technology_id")
	private int id;

	@Column(name= "programming_technology_name")
	private String name;
	
	
	@ManyToOne()
	@JoinColumn(name = "programming_language_id")
	private ProgrammingLanguage programmingLanguage;
}
