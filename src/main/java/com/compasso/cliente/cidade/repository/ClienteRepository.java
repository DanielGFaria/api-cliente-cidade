package com.compasso.cliente.cidade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compasso.cliente.cidade.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNmClienteIgnoreCaseContaining(String nmCliente);
	void deleteById(Long idCliente);

//	public default void updateNmClienteById(String nmCliente, Long idCliente) {
//		Cliente cliente = find(id, Customer.class); //Consider em as JPA EntityManager
//		customer.setName(customerDto.getName);
//		em.merge(customer);
//	}
//	
}
