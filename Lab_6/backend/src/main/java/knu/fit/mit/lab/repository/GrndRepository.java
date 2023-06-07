package knu.fit.mit.lab.repository;

import knu.fit.mit.lab.entity.GrndEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrndRepository extends JpaRepository<GrndEntity, Integer> {
}
