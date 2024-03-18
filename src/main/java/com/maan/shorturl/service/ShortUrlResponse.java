package com.maan.shorturl.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ShortUrlResponse {
	
	@JsonProperty("ShortUrl")
	private String shortUrl;
	
	@JsonProperty("Status")
	private Boolean status;

}
