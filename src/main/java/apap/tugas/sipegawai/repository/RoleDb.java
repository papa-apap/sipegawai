package apap.tugas.sipegawai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tugas.sipegawai.model.RoleModel;

@Repository
public interface RoleDb extends JpaRepository<RoleModel, Long> {

}
