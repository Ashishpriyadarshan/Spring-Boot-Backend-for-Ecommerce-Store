package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//springBoot can scan everything that is under the com.eazybytes but if there is anything outside that then we need to use the
//@EnableJpaRepositories("then package of the repositories")
//@EntityScan("Package of the model")
//@EnableWebSecurity is used when we are using spring framework and not springboot if we aer using springboot then it is smart enough that
//it will automatically include the security even when we don't mention it here
public class EazyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendApplication.class, args);
	}

}
