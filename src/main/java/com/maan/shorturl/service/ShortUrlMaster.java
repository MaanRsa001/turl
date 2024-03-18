package com.maan.shorturl.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="SHORT_URL_MASTER")
@Builder
public class ShortUrlMaster {
	
	
	@Id
	@Column(name ="SHORT_ID")
	private String shortId;
	
	@Column(name ="REQUEST_URL")
	private String requestUrl;
	
	@Column(name ="ENTRY_DATE")
	private Date entryDate;
	
	@Column(name ="STATUS")
	private String status;
	
	@Column(name ="START_DATE")
	private Date startDate;
	
	@Column(name ="END_DATE")
	private Date endDate;
	
	@Column(name ="SHORT_URL")
	private String shortUrl;
		
}
