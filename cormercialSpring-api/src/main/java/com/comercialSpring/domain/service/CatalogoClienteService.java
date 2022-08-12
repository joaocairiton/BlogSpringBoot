package com.comercialSpring.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.comercialSpring.domain.exception.NegocioException;
import com.comercialSpring.domain.model.Cliente;
import com.comercialSpring.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
	private ClienteRepository clienteRepository;

	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
		.stream()
		.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		if (emailEmUso) {
			throw new NegocioException("Este E-mail já exixte!");
			
		}
		
		
		return clienteRepository.save(cliente);
	}
	@Transactional
	public void excluir(Long clienteId){
		clienteRepository.deleteById(clienteId);
	}
	
}
