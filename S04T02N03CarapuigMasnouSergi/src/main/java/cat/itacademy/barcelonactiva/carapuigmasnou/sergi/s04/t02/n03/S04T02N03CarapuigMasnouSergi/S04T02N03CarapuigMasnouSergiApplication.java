package cat.itacademy.barcelonactiva.carapuigmasnou.sergi.s04.t02.n03.S04T02N03CarapuigMasnouSergi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class S04T02N03CarapuigMasnouSergiApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N03CarapuigMasnouSergiApplication.class, args);
	}
}
