package com.maan.shorturl.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ShortUrlReq {
	
	@JsonProperty("RequestUrl")
	private String requestUrl;

}
