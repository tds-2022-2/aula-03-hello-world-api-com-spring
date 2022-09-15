package br.edu.ifrs.riogrande.tads.tds.cobaia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

@RestController
class OlaController {

	// https://subdominio.dominio.ext:8823/path/subpath/subsubpath/resource
	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping(path = "/oi")
	String oi(HttpRequest req) {
		return "Oi mundo!";
	}

	// @GetMapping(path = "/oi", produces = MediaType.APPLICATION_JSON_VALUE)
	// String oi() {
	// 	return "{\"oi\": \"mundo!\"}";
	// }

	Random randomizer = new Random();

	@GetMapping("/piadas")
	String piadas() {
		Collections.shuffle(piadas, randomizer);
		return piadas.get(0);
	}

	List<String> piadas = new ArrayList<>();
	
	OlaController() {
		piadas.add("O que é um pontinho vermelho no rio? Um jacaRed");
		piadas.add("O que é um pontinho verde do Pólo Sul? Um pinGreen");
		piadas.add("O que é um pontinho vermelho em cima da árvore? Um morangotango");
	}
		
}