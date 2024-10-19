package com.keyin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. List all cities");
            System.out.println("2. List all passengers");
            System.out.println("3. List all airports");
            System.out.println("4. List all aircraft");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    listAllCities();
                    break;
                case 2:
                    listAllPassengers();
                    break;
                case 3:
                    listAllAirports();
                    break;
                case 4:
                    listAllAircraft();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listAllCities() {
        String url = "http://localhost:8080/api/cities";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
    }

    private void listAllPassengers() {
        String url = "http://localhost:8080/api/passengers";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
    }

    private void listAllAirports() {
        String url = "http://localhost:8080/api/airports";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
    }

    private void listAllAircraft() {
        String url = "http://localhost:8080/api/aircraft";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
    }
}