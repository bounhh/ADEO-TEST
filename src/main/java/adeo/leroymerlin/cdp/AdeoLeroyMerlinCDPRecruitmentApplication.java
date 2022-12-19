package adeo.leroymerlin.cdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AdeoLeroyMerlinCDPRecruitmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdeoLeroyMerlinCDPRecruitmentApplication.class, args);
	}
}
