package by.TestFireAlarm.repository;

import by.TestFireAlarm.entity.Logins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LoginRepository extends JpaRepository<Logins, Integer> {

    Optional <Logins> findByName(String name);
}
