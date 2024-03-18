package com.maan.shorturl.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ShortUrlServiceImpl implements ShortUrlService{
	
	Logger log = LogManager.getLogger(ShortUrlServiceImpl.class);
	
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";

	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private ShortUrlRepository repo;
	
	
	@Value("${domain.name}")
	private String domainName;

	@Override
	public ShortUrlResponse shortUrl(ShortUrlReq req) {
		ShortUrlResponse response = new ShortUrlResponse();
		try {
			log.info("shortUrl request : "+mapper.writeValueAsString(req));
			
			List<ShortUrlMaster> list =repo.findByRequestUrlIgnoreCase(req.getRequestUrl().toUpperCase());
			
			if(list.isEmpty()) {
				Integer seq =repo.getshortId();
				String shortCode =generateRandomString(4)+seq;
				String shortUrl =domainName+shortCode;
				ShortUrlMaster shortUrlMaster = ShortUrlMaster.builder()
						.shortId(shortCode)
						.endDate(new Date())
						.entryDate(new Date())
						.requestUrl(req.getRequestUrl())
						.shortUrl(shortUrl)
						.startDate(new Date())
						.status("Y")
						.build();
				ShortUrlMaster result=	repo.save(shortUrlMaster);
				
				response.setShortUrl(result.getShortUrl());
				response.setStatus(true);
			}else {
				response.setShortUrl(list.get(0).getShortUrl());
				response.setStatus(true);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			response.setShortUrl(null);
			response.setStatus(false);
		}
		return response;
	}
	
	public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

	@Override
	public String getShortUrl(String shortCode) {
		String requestUrl ="";
		try {
			java.util.Optional<ShortUrlMaster> data =repo.findById(shortCode);
			
			if(data.isPresent()) {
				requestUrl =data.get().getRequestUrl();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return requestUrl;
	}

	

}
