package com.maan.shorturl.service;

public interface ShortUrlService {

	ShortUrlResponse shortUrl(ShortUrlReq req);

	String getShortUrl(String shorturl);

}
