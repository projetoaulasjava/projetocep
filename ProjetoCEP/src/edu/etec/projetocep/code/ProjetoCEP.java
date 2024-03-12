package edu.etec.projetocep.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ProjetoCEP {

	public static void main(String[] args) {
		
		String numeroCep = "19802122";
		
		try{
			
			URL url = new URL("https://viacep.com.br/ws/" + numeroCep + "/json/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			int responseCode = connection.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK){
				BufferedReader reader = new BufferedReader(new InputStreamReader (connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				
				while ((line = reader.readLine()) != null){
					response.append(line);
					
				}
				reader.close();
				
				System.out.println(response.toString());
			}
			
			else{
				System.out.println("Falha ao tentar obter o CEP" + responseCode);
			}
			
		}catch(Exception e){
			System.out.println(e);
		}

	}

}
