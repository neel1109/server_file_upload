package com.gdi.dummy_video;

import com.google.gson.annotations.SerializedName;

public class ModelResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("meta")
	private Meta meta;

	@SerializedName("timezone")
	private String timezone;

	@SerializedName("timestamp")
	private int timestamp;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	public String getTimezone(){
		return timezone;
	}

	public void setTimestamp(int timestamp){
		this.timestamp = timestamp;
	}

	public int getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"ModelResponse{" + 
			"data = '" + data + '\'' + 
			",meta = '" + meta + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}