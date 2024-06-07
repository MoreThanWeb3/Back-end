package com.car.show.Repository;

import com.car.show.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existsByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
