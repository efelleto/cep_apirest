package dev.felleto;

import dev.felleto.services.ApiService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ApiService apiService = new ApiService();
        try {
            System.out.println(apiService.getAddress("01001000"));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        } catch (InterruptedException exception){
            throw new RuntimeException(exception);
        }
    }
}