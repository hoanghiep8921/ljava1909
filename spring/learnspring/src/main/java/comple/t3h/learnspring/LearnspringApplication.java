package comple.t3h.learnspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class LearnspringApplication implements CommandLineRunner {
	@Autowired
	private Outfit outfit;
	@Autowired
	private Accessories accessories;
	@Autowired
	@Qualifier("japanStyle")
	private HairStyle hairStyle;

	public static void main(String[] args) {
		SpringApplication.run(LearnspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Girl ngoctrinh = new Girl(hairStyle,accessories,outfit);
		System.out.println(ngoctrinh.toString());
	}
}
