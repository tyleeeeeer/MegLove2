package com.example.demo.repository;

import com.example.demo.domain.Mob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobRepository extends JpaRepository<Mob, Long> {
}
