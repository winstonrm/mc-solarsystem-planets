package com.punk.astronomy.solarsystem.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.punk.astronomy.solarsystem.dto.Planet;
import com.punk.astronomy.solarsystem.util.StringsContents;
import com.punk.astronomy.solarsystem.util.Util;

@Service
public class PlanetServiceImpl implements PlanetService{

	static int codigoSucesso = StringsContents.CODE_200;
	
	@Override
	public List<Planet> getPlanetsData() throws Exception {
		
		String urlForCall = StringsContents.MS_SERVER_DATA;

		try {
			URL url = new URL(urlForCall);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			if (connection.getResponseCode() != codigoSucesso)
				throw new RuntimeException("HTTP error code : " + connection.getResponseCode());

			BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
			String jsonEmString = Util.convertJsonToString(response);

			Gson gson = new Gson();			
			Type collectionType = new TypeToken<Collection<Planet>>(){}.getType();
			List<Planet> enums = gson.fromJson(jsonEmString, collectionType);

			return enums;
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}

	}
	

}
