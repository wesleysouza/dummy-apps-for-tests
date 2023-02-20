package dummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DummyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummyApplication.class, args);
	}


	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "INDEX!";
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String api() {
		return "API!";
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message() {
		return "Message!";
	}

}
