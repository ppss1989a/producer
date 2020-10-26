package br.com.assertiva.service;

import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.assertiva.feign.Mensagem;
import br.com.assertiva.feign.MensagemJSON;


@Component
public class ProducerService {
	    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
	    private static final String TOPIC = "mensagem";


		@Autowired
		KafkaTemplate<Integer,String> kafkaTemplate;
		@Autowired
		ObjectMapper objectMapper;
		
		
		
		public void enviaMensagemJson( List <MensagemJSON> mensagem) throws JsonProcessingException {

			for (MensagemJSON m : mensagem) {
				Integer key = Integer.valueOf(m.getId().intValue());
				String value = objectMapper.writeValueAsString(m);
		        ProducerRecord<Integer,String> producerRecord = buildProducerRecord(key, value, TOPIC);

		        ListenableFuture<SendResult<Integer,String>> listenableFuture =  kafkaTemplate.send(producerRecord);

		        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
					@Override
					public void onFailure(Throwable ex) {
						System.out.println("Erro"+ex);
					}

					@Override
					public void onSuccess(SendResult<Integer, String> result) {
						handleSuccess(key, value, result);
					}
				});

			}
		}
	

	public void enviaMensagem( Mensagem mensagem) throws JsonProcessingException {
			Integer key = Integer.valueOf(mensagem.getId().intValue());
			String value = objectMapper.writeValueAsString(mensagem);
	        ProducerRecord<Integer,String> producerRecord = buildProducerRecord(key, value, TOPIC);

	        ListenableFuture<SendResult<Integer,String>> listenableFuture =  kafkaTemplate.send(producerRecord);

	        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
				@Override
				public void onFailure(Throwable ex) {
					System.out.println("Erro"+ex);
				}

				@Override
				public void onSuccess(SendResult<Integer, String> result) {
					handleSuccess(key, value, result);
				}
			});
		}


	private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topic) {
        List<Header> recordHeaders = List.of(new RecordHeader("event-source", "scanner".getBytes()));
        return new ProducerRecord<>(topic, null, key, value, recordHeaders);
    }
	
		private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {
			System.out.println("Mesagem enviada com sucesso com chave : "+key+ "e valor "+value.toString() +" na partição "+ result.getRecordMetadata().partition()+""+result.getRecordMetadata().offset()+""+result.getRecordMetadata().timestamp());
		}
	}
