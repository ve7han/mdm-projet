package Repository;

import Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    Profile findByCodeProfile(String codeprofile);
}
