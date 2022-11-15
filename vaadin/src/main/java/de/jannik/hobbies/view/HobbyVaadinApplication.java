package de.jannik.hobbies.view;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import de.jannik.hobbies.view.config.VaadinConfiguration;
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
@Import(VaadinConfiguration.class)
@EnableVaadin({"de.jannik.hobbies"})
public class HobbyVaadinApplication
{
  public static void main(String[] args)
  {
    SpringApplication.run(HobbyVaadinApplication.class, args);
  }
}
