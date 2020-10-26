package br.com.assertiva.feign;

import java.sql.Timestamp;

public class MensagemJSON {
	
	    String mensagem;
	    String numero;
	    Timestamp agendamento;
	    Integer id;
	    String aggregatedId;
	    Boolean flashSms;
	    String callBackOption;
	    Integer dataCoding;
	    Long batchId;
	    
	    public MensagemJSON() {
	    }

	    public String getMensagem() {
	        return mensagem;
	    }

	    public void setMensagem(String mensagem) {
	        this.mensagem = mensagem;
	    }

	    public String getNumero() {
	        return numero;
	    }

	    public void setNumero(String numero) {
	        this.numero = numero;
	    }

	    public Timestamp getAgendamento() {
	        return agendamento;
	    }

	    public void setAgendamento(Timestamp agendamento) {
	        this.agendamento = agendamento;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Boolean getFlashSms() {
	        return flashSms;
	    }

	    public void setFlashSms(Boolean flashSms) {
	        this.flashSms = flashSms;
	    }

	    public String getCallBackOption() {
	        return callBackOption;
	    }

	    public void setCallBackOption(String callBackOption) {
	        this.callBackOption = callBackOption;
	    }

	    public Integer getDataCoding() {
	        return dataCoding;
	    }

	    public void setDataCoding(Integer dataCoding) {
	        this.dataCoding = dataCoding;
	    }

	    public Long getBatchId() {
	        return batchId;
	    }

	    public void setBatchId(Long batchId) {
	        this.batchId = batchId;
	    }

	    public String getAggregatedId() {
	        return aggregatedId;
	    }

	    public void setAggregatedId(String aggregatedId) {
	        this.aggregatedId = aggregatedId;
	    }

	    @Override
	    public String toString() {
	        return "Mensagem{" +
	                "mensagem='" + mensagem + '\'' +
	                ", numero='" + numero + '\'' +
	                ", agendamento=" + agendamento +
	                ", id=" + id +
	                ", aggregatedId='" + aggregatedId + '\'' +
	                ", flashSms=" + flashSms +
	                ", callBackOption='" + callBackOption + '\'' +
	                ", dataCoding=" + dataCoding +
	                ", batchId=" + batchId +
	                '}';
	    }


}
