package saiyed.rushan.runnerz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import saiyed.rushan.runnerz.user.UserHttpClient;

@SpringBootApplication
public class RunnerzApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
	}

	@Bean
	UserHttpClient userHttpClient() {
		RestClient restClient = RestClient.create("http://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHttpClient.class);
	}
}
