package com.zyh.factory.transman;

import java.util.ArrayList;
import java.util.List;

public class TransMessage {

	private final static int RESP_CODE_OK = 0;
	private final static int RESP_CODE_ERROR = 1;
	private int respCode;
	private String userId;
	private List<String> message;
	

	public TransMessage() {
		this.respCode = RESP_CODE_OK;
	}
	public boolean shouStop() {
		return (this.respCode == RESP_CODE_OK) ? false : true;
	}
	public void doSetError(String msg) {
		this.respCode = RESP_CODE_ERROR;
		if (message == null) {
			message = new ArrayList<>();
		}
		message.add(msg);
	}
	
	public int getRespCode() {
		return respCode;
	}
	public void setRespCode(int respCode) {
		this.respCode = respCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	
	
}
