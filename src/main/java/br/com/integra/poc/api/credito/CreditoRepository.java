package br.com.integra.poc.api.credito;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.integra.poc.api.credito.entity.Credito;

public interface CreditoRepository extends JpaRepository<Credito, Long> {

	@Query("select credito from Credito credito where numeroNfse=:numeroNfse")
	List<Credito> consultarPorNumeroNfse(String numeroNfse); 
	
	@Query("select credito from Credito credito where numeroCredito=:numeroCredito")
	Credito consultarPorNumeroCredito(String numeroCredito); 

}
