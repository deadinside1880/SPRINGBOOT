package com.example.First_project;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.example.First_project.run.Location;
import com.example.First_project.run.Run;
import com.example.First_project.user.UserHttpClient;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);

		Run run = new Run(1, "First Run", 5, Location.OUTDOOR, LocalDateTime.now(),
				LocalDateTime.now().plus(1, ChronoUnit.HOURS), 0);
		System.out.println(run);

	}

	@Bean
	UserHttpClient userHttpClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
				.build();
		return factory.createClient(UserHttpClient.class);
	}

}
