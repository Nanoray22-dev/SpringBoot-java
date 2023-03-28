package live.live;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiveApplication {

	public static void main(String[] args) {
		System.out.println("Welcomo to the word of the Java!");
		SpringApplication.run(LiveApplication.class, args);
	}

}
