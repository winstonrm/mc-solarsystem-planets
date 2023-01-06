package com.punk.astronomy.solarsystem.util;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {
	public static String convertJsonToString(BufferedReader buffereReader) throws IOException {
		String response, jsonToString = "";
		while ((response = buffereReader.readLine()) != null) {
			jsonToString += response;
		}
		return jsonToString;
	}
}