package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.eazybytes.accounts.controller") })
@EnableJpaRepositories("com.eazybytes.accounts.repository")
@EntityScan("com.eazybytes.accounts.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@OpenAPIDefinition(
		info=@Info(
				title = "Accounts microservice REST API Documentation",
				description = "Accounts microservice REST API Documentation",
				version = "v1",
				contact=@Contact(
						name = "Monesh",
						email = "monesh@gamil.com",
						url = "https://moness.com"  // this url sepecifies where you can contact me for more informatingl
				),
				license=@License(
						name="Apache.2.0",
						url="https//www.urloflicense.com" // this url specifies where you can get more information about license
				)
		),
		externalDocs =@ExternalDocumentation(
				description = "Eazybank Accounts Documentation",
				url="https://www.swagger.ui.html" // where you can see the documentation
		)

		/* We can also mention details of security which we are providing ,server details which we can provide
		* and also tags name which we can provide*/
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
