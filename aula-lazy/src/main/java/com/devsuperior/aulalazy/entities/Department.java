package com.devsuperior.aulalazy.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;

	/*- Para-um: EAGER(Ansioso/impaciente) -> Ao relaizar o carregamento da entidade e lea tiver uma outra entidade associada para-um, essa outra vai vir na mesma hora.
	- Para-muitos: LAZY(Preguiçoso/tardio) -> AO buscar uma entidade e tiver outras associadas para-muito, essas outras não serão carregadas. Só serão carregadas se você precisar desse dados (tendo que voltar ao banco de dados várias vezes). Portanto, o comportamento LAZY faz a JPA enviar novas consultas se for necessário.
	-Deve-se evitar a mudar um relacionamento que é LAZY para EAGER
	- O ideal para que haja performance é realizar a consulta customização
	*/
	@OneToMany(mappedBy = "department")
	public List<Employee> employees = new ArrayList<>();
	
	public Department() {
	}

	public Department(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
}
