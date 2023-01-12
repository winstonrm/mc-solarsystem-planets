package com.punk.astronomy.solarsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.punk.astronomy.solarsystem.service.PlanetServiceImpl;

@RestController
@RequestMapping("/api/astro")
public class PlanetsController {

	@Autowired
	PlanetServiceImpl planetServiceImpl;

	@GetMapping("/planettest")
	public String earthTest() {
		return "Controller Test";
	}

	@GetMapping("/planet/{planetId}")
	public String getPlanetById(@PathVariable int planetId) throws Exception {	
		try {
			return planetServiceImpl.getPlanetsData().get(planetId).toString();
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
	}

}
