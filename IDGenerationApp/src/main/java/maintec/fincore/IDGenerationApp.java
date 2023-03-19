package com.maintec.fincore;

import com.maintec.fincore.entity.Branch;
import com.maintec.fincore.entity.ID;
import com.maintec.fincore.entity.User;
import com.maintec.fincore.repository.BranchRepository;
import com.maintec.fincore.repository.IDRepository;
import com.maintec.fincore.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
   info = @Info(
   title = "ID Generation API",
   version = "1.0",
   description = "ID Generation"
)
)
public class IDGenerationApp {
   @Autowired
   private IDRepository idRepository;
   @Autowired
   private BranchRepository branchRepository;
   @Autowired
   private UserRepository userRepository;

   public static void main(String[] args) {
      SpringApplication.run(IDGenerationApp.class, args);
   }

   @Bean
   public CommandLineRunner commandLineRunner() {
      return args -> {
         Branch branch = new Branch();
         this.branchRepository.save(branch);
         User user = new User();
         user.setBranch(branch);
         this.userRepository.save(user);
         ID id = new ID();
         id.setBranch(branch);
         id.setEnteredBy(user);
         id.setCreationDate(LocalDate.now());
         id.setEnteredDate(LocalDate.now());
         this.idRepository.save(id);
      };
   }
}
