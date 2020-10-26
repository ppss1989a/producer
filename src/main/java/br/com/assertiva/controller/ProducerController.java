package br.com.assertiva.controller;


import java.util.List;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.assertiva.feign.Mensagem;
import br.com.assertiva.feign.MensagemJSON;
import br.com.assertiva.service.ProducerService;

@RestController
public class ProducerController {

	private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

	@Autowired
	ProducerService mensageEventProducer;

	@GetMapping()
	public String oi(){

		return "oi";
	}

	@PostMapping("/send/mensagem")
	public ResponseEntity<List<MensagemJSON>> post(@RequestBody List<MensagemJSON> mensagem) throws JsonProcessingException, ExecutionException, InterruptedException {
		mensageEventProducer.enviaMensagemJson(mensagem);
		return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
	}
	
	
	@PostMapping("/send")
	public ResponseEntity <Mensagem> postMensagem(@RequestBody Mensagem mensagem) throws JsonProcessingException, ExecutionException, InterruptedException {
		mensageEventProducer.enviaMensagem(mensagem);
		return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
	}


}
