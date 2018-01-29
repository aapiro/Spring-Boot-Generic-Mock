package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class HelloController {

	@Value("${local.path}")
	String localPath;

	@Value("${ext.file}")
	String extFile;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
			RequestMethod.DELETE }, produces = "application/json")
	@ResponseBody
	public String allFallback(HttpServletRequest request) {

		String uri = request.getRequestURI().concat("/");
		String jsonResource = localPath + uri + request.getMethod() + extFile;

		return readFile(jsonResource, StandardCharsets.UTF_8);
	}

	public String readFile(String path, Charset encoding) {
		byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(Paths.get(path));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(encoded, encoding);
	}

}
