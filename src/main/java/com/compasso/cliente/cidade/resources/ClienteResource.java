package com.compasso.cliente.cidade.resources;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.cliente.cidade.models.Cliente;
import com.compasso.cliente.cidade.repository.ClienteRepository;

@RestController
@Service
@RequestMapping(value="/api")
public class ClienteResource {

	private HttpStatus http; 
	
	@Autowired
	private ClienteRepository ClienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listaClientes(){
		return ClienteRepository.findAll();
	}
	
	@GetMapping("/clientePorId/{id}")
	public Optional<Cliente> listaClientePorId(@PathVariable(value="id") Long idCliente){
		return ClienteRepository.findById(idCliente);
	}
	
	
	@GetMapping("/clientePorNome/{nome}")
	public List<Cliente> listaClientePorNome(@PathVariable(value="nome") String nmCliente){
		return ClienteRepository.findByNmClienteIgnoreCaseContaining(nmCliente);
	}
	
	@DeleteMapping("/apagaClientePorId/{id}")
	public ResponseEntity<Object> apagaClientePorId(@PathVariable(value="id") Long idCliente){
		try {

		ClienteRepository.deleteById(idCliente);
		 		return new ResponseEntity<>(HttpStatus.OK);
			}catch(Exception e) {
				 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

	private Cliente salvaCliente(@RequestBody Cliente cliente){
		return ClienteRepository.save(cliente);
	}
	
	@PostMapping("/alteraNomeCliente")
	public ResponseEntity<Object> AlteraNomeCliente(@RequestBody Cliente cliente){
		Optional<Cliente> clienteAlteracao = ClienteRepository.findById(cliente.getIdCliente());
		try {
			if(cliente.getIdCliente() != null) {
				if(clienteAlteracao.isPresent()) {
					clienteAlteracao.get().setNmCliente(cliente.getNmCliente());
					this.salvaCliente(clienteAlteracao.get());
				}
			}
			 return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/cadastrarCliente")
	public ResponseEntity<Object> cadastrarCliente(@RequestBody Cliente cliente){
		try {
			if(cliente.getIdCliente() == null) {
					this.salvaCliente(cliente);
				}
			 return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
