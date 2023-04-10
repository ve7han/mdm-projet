package MDM_projet;

import Model.Profile;
import Model.User;
import Repository.ProfileRepository;
import Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.l;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "Repository")
public class MdmApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MdmApplication.class, args);
	}

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private UserRepository userRepository;


	public void run(String... args) throws Exception {
		Profile superAdminProfile = new Profile();
		superAdminProfile.setLibele("admin");
		superAdminProfile.setCodeprofile("SUPER_ADMIN");
		profileRepository.save(superAdminProfile);

		Profile adminProfile = new Profile();
		adminProfile.setLibele("Admin");
		adminProfile.setCodeprofile("ADMIN");
		profileRepository.save(adminProfile);

		Profile chefEntrepriseProfile = new Profile();
		chefEntrepriseProfile.setLibele("Chef d'entreprise");
		chefEntrepriseProfile.setCodeprofile("CHEF_ENTREPRISE");
		profileRepository.save(chefEntrepriseProfile);

		Profile employeeProfile = new Profile();
		employeeProfile.setLibele("Employee");
		employeeProfile.setCodeprofile("EMPLOYEE");
		profileRepository.save(employeeProfile);



		User superAdmin = new User();
		superAdmin.setUsername("john");
		superAdmin.setNom("Doe");
		superAdmin.setPrenom("John");
		superAdmin.setEmail("john.doe@gmail.com");
		superAdmin.setPassword("password1");
		superAdmin.setDate_naissance(LocalDate.of(1990, 1, 1));
		superAdmin.setProfile(superAdminProfile);
		userRepository.save(superAdmin);

		User admin = new User();
		admin.setUsername("hadak");
		admin.setNom("hada");
		admin.setPrenom("k");
		admin.setEmail("hadak@gmail.com");
		admin.setPassword("password2");
		admin.setDate_naissance(LocalDate.of(1995, 2, 2));
		admin.setProfile(adminProfile);
		userRepository.save(admin);

		User chefEntreprise = new User();
		chefEntreprise.setUsername("molchi");
		chefEntreprise.setNom("mol");
		chefEntreprise.setPrenom("chi");
		chefEntreprise.setEmail("molchi@gmail.com");
		chefEntreprise.setPassword("password3");
		chefEntreprise.setDate_naissance(LocalDate.of(1980, 3, 3));
		chefEntreprise.setProfile(chefEntrepriseProfile);
		userRepository.save(chefEntreprise);

		User employee = new User();
		employee.setUsername("mowdaf");
		employee.setNom("mow");
		employee.setPrenom("daf");
		employee.setEmail("mowdaf@gmail.com");
		employee.setPassword("password4");
		employee.setDate_naissance(LocalDate.of(2000, 4, 4));
		employee.setProfile(employeeProfile);
		userRepository.save(employee);
	}
}




