package apap.tugas.sipegawai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tugas.sipegawai.model.PegawaiModel;

import java.util.Optional;

@Repository
public interface PegawaiDb extends JpaRepository<PegawaiModel, String> {
    Optional<PegawaiModel> findByUsername(String username);
}