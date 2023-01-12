package com.punk.astronomy.solarsystem.Service;

import java.util.List;

import com.punk.astronomy.solarsystem.dto.Planet;
 
public interface PlanetService {
	
	public List<Planet> getPlanetsData() throws Exception;

}
