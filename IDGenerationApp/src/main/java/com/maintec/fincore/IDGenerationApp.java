package com.maintec.fincore;

import com.maintec.fincore.entity.Branch;
import com.maintec.fincore.entity.GeneralMasters;
import com.maintec.fincore.entity.ID;
import com.maintec.fincore.entity.User;
import com.maintec.fincore.repository.BranchRepository;
import com.maintec.fincore.repository.GeneralMastersRepository;
import com.maintec.fincore.repository.IDRepository;
import com.maintec.fincore.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

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
   private GeneralMastersRepository generalMastersRepository;
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
         //GeneralMasters generalMasters = new GeneralMasters();
         //generalMasters.setDescription("Institution");
         //generalMasters.setMasterType("Firm");
         //generalMastersRepository.save(generalMasters);
      };
   }

   @Bean
   public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
      ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
      resourceDatabasePopulator.addScript(new ClassPathResource("/data.sql.bak"));
      DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
      dataSourceInitializer.setDataSource(dataSource);
      dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
      return dataSourceInitializer;
   }
}
