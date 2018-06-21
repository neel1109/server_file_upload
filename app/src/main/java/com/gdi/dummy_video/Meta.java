package com.gdi.dummy_video;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("code")
	private Object code;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setCode(Object code){
		this.code = code;
	}

	public Object getCode(){
		return code;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"code = '" + code + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}