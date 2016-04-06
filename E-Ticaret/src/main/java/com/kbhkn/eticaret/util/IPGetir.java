package com.kbhkn.eticaret.util;

public class IPGetir {

	private static String IPAddress = null;
	private static final String[] IPHeaderList = { 
			"X-Forwarded-For",
			"Proxy-Client-IP",
			"WL-Proxy-Client-IP",
			"HTTP_X_FORWARDED_FOR",
			"HTTP_X_FORWARDED",
			"HTTP_X_CLUSTER_CLIENT_IP",
			"HTTP_CLIENT_IP",
			"HTTP_FORWARDED_FOR",
			"HTTP_FORWARDED",
			"HTTP_VIA",
			"REMOTE_ADDR" 
	};

	public static String getClientRealIpAdress(javax.servlet.http.HttpServletRequest req) {
		for (String header : IPHeaderList) {
			IPAddress = req.getHeader(header);
			if (IPAddress != null && IPAddress.length() != 0 && !"unknown".equalsIgnoreCase(IPAddress)) {
				return IPAddress;
			}
		}
		return req.getRemoteAddr();
	}
}