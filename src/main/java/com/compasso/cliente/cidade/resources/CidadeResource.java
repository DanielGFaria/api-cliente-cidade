package com.compasso.cliente.cidade.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.cliente.cidade.models.Cidade;
import com.compasso.cliente.cidade.models.Cliente;
import com.compasso.cliente.cidade.repository.CidadeRepository;


@RestController
@Service
@RequestMapping(value="/api")
public class CidadeResource {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping("/cidades")
	public List<Cidade> listaCidades(){
		return cidadeRepository.findAll();
	}
	
	@GetMapping("/cidadePorNome/{nome}")
	public List<Cidade> buscaCidadePorNome(@PathVariable(value="nome") String nmCidade){
		return cidadeRepository.findByNmCidadeIgnoreCase(nmCidade);
	}
	
	@GetMapping("/cidadePorEstado/{uf}")
	public List<Cidade> buscaCidadePorEstado(@PathVariable(value="uf") String idEstado){
		return cidadeRepository.findByIdEstadoIgnoreCase(idEstado);
	}
	
	private Cidade salvaCidade(@RequestBody Cidade cidade){
		return cidadeRepository.save(cidade);
	}
	
	@PostMapping("/cadastrarCidade")
	public ResponseEntity<Object> cadastrarCliente(@RequestBody Cidade cidade){
		try {
			if(cidade.getIdCidade() == null) {
					this.salvaCidade(cidade);
				}
			 return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
