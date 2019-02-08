package com.compasso.cliente.cidade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compasso.cliente.cidade.models.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	List<Cidade> findByNmCidadeIgnoreCase(String nmCidade);
	List<Cidade> findByIdEstadoIgnoreCase(String idEstado);

}
