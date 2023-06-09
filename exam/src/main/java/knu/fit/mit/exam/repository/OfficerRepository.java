package knu.fit.mit.exam.repository;

import knu.fit.mit.exam.entity.OfficerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "officers", path = "officers")
public interface OfficerRepository extends JpaRepository<OfficerEntity, Long> {
}
