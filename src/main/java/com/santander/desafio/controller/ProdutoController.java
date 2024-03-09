package com.santander.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.santander.desafio.core.produto.entity.ProdutoEntity;
import com.santander.desafio.core.produto.service.AlterarProdutoService;
import com.santander.desafio.core.produto.service.BuscarProdutoCodigoService;
import com.santander.desafio.core.produto.service.CadastrarProdutoService;
import com.santander.desafio.core.produto.service.ExcluirProdutoService;

@RestController
@RequestMapping("/v1/produto")
public class ProdutoController {
	
	@Autowired
	private CadastrarProdutoService cadastrarProdutoService;
	
	@Autowired
	private BuscarProdutoCodigoService buscarProdutoCodigoService;
	
	@Autowired
	private AlterarProdutoService alterarProdutoService;
	
	@Autowired
	private ExcluirProdutoService excluirProdutoService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void salvar(@RequestBody ProdutoEntity produto) {
		cadastrarProdutoService.executar(produto);
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void editar(@RequestBody ProdutoEntity produto) {
		alterarProdutoService.executar(produto);
	}
	
	@DeleteMapping("{codigo}")
	@ResponseStatus(code = HttpStatus.OK)
	public void editar(@PathVariable String codigo) {
		excluirProdutoService.executar(codigo);
	}
	
	@GetMapping("{codigo}")
	public ResponseEntity<ProdutoEntity> buscarPorDocumento(@PathVariable String codigo) {
		
		ProdutoEntity produto = buscarProdutoCodigoService.executar(codigo);
		return ResponseEntity.ok(produto);
	}
}