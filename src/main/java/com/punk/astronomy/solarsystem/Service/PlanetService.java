package com.punk.astronomy.solarsystem.service;

import java.util.List;

import com.punk.astronomy.solarsystem.dto.Planet;
 
public interface PlanetService {
	
	public List<Planet> getPlanetsData() throws Exception;

}
