package com.instanthire.model;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Component
@ConfigurationProperties("paytm.payment.sandbox")
public class PaytmDetailPojo {
	
private String merchantId;
	
	private String merchantKey;
	
	private String channelId;
	
	private String website;
	
	private String industryTypeId;
	
	private String paytmUrl;
	
	/////////////////////////////
	
	private String CUST_ID;

    private String TXN_AMOUNT;

	private String CHANNEL_ID;

	private String ORDER_ID;

	private String INDUSTRY_TYPE_ID;
	
	public String getCUST_ID() {
		return CUST_ID;
	}


	public void setCUST_ID(String cUST_ID) {
		CUST_ID = cUST_ID;
	}


	public String getTXN_AMOUNT() {
		return TXN_AMOUNT;
	}


	public void setTXN_AMOUNT(String tXN_AMOUNT) {
		TXN_AMOUNT = tXN_AMOUNT;
	}


	public String getCHANNEL_ID() {
		return CHANNEL_ID;
	}


	public void setCHANNEL_ID(String cHANNEL_ID) {
		CHANNEL_ID = cHANNEL_ID;
	}


	public String getORDER_ID() {
		return ORDER_ID;
	}


	public void setORDER_ID(String oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}


	public String getINDUSTRY_TYPE_ID() {
		return INDUSTRY_TYPE_ID;
	}


	public void setINDUSTRY_TYPE_ID(String iNDUSTRY_TYPE_ID) {
		INDUSTRY_TYPE_ID = iNDUSTRY_TYPE_ID;
	}


	////////////////////////////////
	private Map<String, String> details;
	
	public PaytmDetailPojo() {}
	

	


	public String getMerchantId() {
		return merchantId;
	}


	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}


	public String getMerchantKey() {
		return merchantKey;
	}


	public void setMerchantKey(String merchantKey) {
		this.merchantKey = merchantKey;
	}


	public String getChannelId() {
		return channelId;
	}


	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getIndustryTypeId() {
		return industryTypeId;
	}


	public void setIndustryTypeId(String industryTypeId) {
		this.industryTypeId = industryTypeId;
	}


	public String getPaytmUrl() {
		return paytmUrl;
	}


	public void setPaytmUrl(String paytmUrl) {
		this.paytmUrl = paytmUrl;
	}


	public Map<String, String> getDetails() {
		return details;
	}


	public void setDetails(Map<String, String> details) {
		this.details = details;
	}
	
	

}
