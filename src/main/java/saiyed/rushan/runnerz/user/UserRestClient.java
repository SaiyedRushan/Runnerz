package saiyed.rushan.runnerz.user;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class UserRestClient {
    private final RestClient restClient;

    public UserRestClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
    }
    List<User> findAll() {
        return restClient
                .get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<List<User>>() {});
    }

    User findById(Integer id) {
        return restClient
                .get()
                .uri("/users/" + id)
                .retrieve()
                .body(User.class);
    }

}
