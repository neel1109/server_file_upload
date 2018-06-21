package com.gdi.dummy_video;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("size")
	private int size;

	@SerializedName("mimetype")
	private String mimetype;

	@SerializedName("url")
	private String url;

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return size;
	}

	public void setMimetype(String mimetype){
		this.mimetype = mimetype;
	}

	public String getMimetype(){
		return mimetype;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",size = '" + size + '\'' + 
			",mimetype = '" + mimetype + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}