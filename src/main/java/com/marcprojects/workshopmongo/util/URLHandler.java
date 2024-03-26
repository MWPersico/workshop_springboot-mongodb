package com.marcprojects.workshopmongo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLHandler {
	public static String decodeURLParameter(String param) {
		try {
			return URLDecoder.decode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
