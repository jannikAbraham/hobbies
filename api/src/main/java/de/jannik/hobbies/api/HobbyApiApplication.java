package de.jannik.hobbies.api;

import de.jannik.hobbies.api.config.ApiConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "de.jannik.hobbies" })
@EnableJpaAuditing
@EntityScan(basePackages = { "de.jannik.hobbies" })
@EnableJpaRepositories(basePackages = { "de.jannik.hobbies" })
@Import(ApiConfiguration.class)
public class HobbyApiApplication
{
  public static void main(String[] args)
  {
    SpringApplication.run(HobbyApiApplication.class, args);
  }
}
