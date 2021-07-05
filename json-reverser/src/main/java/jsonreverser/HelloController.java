package jsonreverser;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
	private ObjectMapper objectMapper = new ObjectMapper();
	final private static String JSON_SERVER_ENDPOINT = "http://json-server:8080";


	// @GetMapping("/")
	// public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	// 	model.addAttribute("name", name);
	// 	return "greeting";
	// }


	
    @RequestMapping("/reverse")
    @ResponseBody
    public MessageDTO  index() throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
    	// Fetch message  from json-server
    	/*
    	 * Simplest approach is to use k8s local DNS to reach the server using
    	 * 	json-server.default.svc.cluster.local
    	 */
    	
	
		MessageDTO message = 
    			  objectMapper.readValue(new URL(JSON_SERVER_ENDPOINT), MessageDTO.class);
    	
        // Reverse the message using MessageDTO 
    	message.setMessage(message.reverseMessage());
    
        
        return message;
    }
    
}

