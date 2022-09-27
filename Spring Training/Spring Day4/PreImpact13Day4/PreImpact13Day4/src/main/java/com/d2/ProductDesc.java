package com.d2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class ProductDesc {
	@Value("Very Good")
	private String prod_quality;
	@Value("Apple")
	private String prod_brand;

	public String getProd_quality() {
		return prod_quality;
	}

	public void setProd_quality(String prod_quality) {
		this.prod_quality = prod_quality;
	}

	public String getProd_brand() {
		return prod_brand;
	}

	public void setProd_brand(String prod_brand) {
		this.prod_brand = prod_brand;
	}

	@Override
	public String toString() {
		return "ProductDesc [prod_quality=" + prod_quality + ", prod_brand=" + prod_brand + "]";
	}
	
	

}
