package dev.felleto.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.felleto.dto.AddressDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    AddressDTO addressDTO = new AddressDTO();

    public AddressDTO getAddress(String cep) throws IOException, InterruptedException {
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://viacep.com.br/ws/"+ cep + "/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            addressDTO = mapper.readValue(response.body(), AddressDTO.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return addressDTO;
    }
}
