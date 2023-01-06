package com.punk.astronomy.solarsystem.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.punk.astronomy.solarsystem.dto.Planets;
import com.punk.astronomy.solarsystem.util.StringsContents;
import com.punk.astronomy.solarsystem.util.Util;


@RestController
@RequestMapping("/api/astro")
public class PlanetsController {

	static int codigoSucesso = StringsContents.CODE_200;

	@GetMapping("/earthtest")
	public String earthTest() {
		return "Controller Test";
	}

	public List<Planets> getPlanetsData() throws Exception {
		String urlForCall = StringsContents.MS_SERVER_DATA;

		try {
			URL url = new URL(urlForCall);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			if (connection.getResponseCode() != codigoSucesso)
				throw new RuntimeException("HTTP error code : " + connection.getResponseCode());

			BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
			String jsonEmString = Util.convertJsonToString(response);

			Gson gson = new Gson();			
			Type collectionType = new TypeToken<Collection<Planets>>(){}.getType();
			List<Planets> enums = gson.fromJson(jsonEmString, collectionType);

			return enums;
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
		
	}
	@GetMapping("/earth")
	public String earth() throws Exception {		

		try {
			List<Planets> enums = getPlanetsData();

			return enums.get(3).toString();
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
	}

}
