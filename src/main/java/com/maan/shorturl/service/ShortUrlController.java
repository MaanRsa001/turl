package com.maan.shorturl.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortUrlController {
	
	
	@Autowired
	private  ShortUrlService service;
	
	
	@PostMapping("/getTUrl")
	public ShortUrlResponse shortUrl(@RequestBody ShortUrlReq req ) {
		return service.shortUrl(req);
	}
	
	
	@GetMapping("/{shorturl}")
	public void getShortUrl(@PathVariable("shorturl") String shorturl,HttpServletResponse res) throws IOException {
		String shortUrl =service.getShortUrl(shorturl);
	    res.sendRedirect(shortUrl);
	}

}
