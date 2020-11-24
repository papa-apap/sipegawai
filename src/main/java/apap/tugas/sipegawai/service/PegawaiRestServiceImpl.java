package apap.tugas.sipegawai.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.management.InstanceAlreadyExistsException;
import javax.transaction.Transactional;

import apap.tugas.sipegawai.model.RoleModel;
import apap.tugas.sipegawai.repository.RoleDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import apap.tugas.sipegawai.model.PegawaiModel;
import apap.tugas.sipegawai.repository.PegawaiDb;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class PegawaiRestServiceImpl implements PegawaiRestService {
  @Autowired
  private PegawaiDb pegawaiDb;

  @Autowired
  private RoleDb roleDb;

  @Override
  public PegawaiModel createPegawai(PegawaiModel pegawai) {
    Optional<PegawaiModel> pegawaiLama = pegawaiDb.findByUsername(pegawai.getUsername());
    if (pegawaiLama.isPresent()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sudah ada pegawai dengan username " + pegawai.getUsername());
    }
    Optional<RoleModel> role = roleDb.findById(pegawai.getRole().getIdRole());
    if (role.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tidak ada role dengan id " + pegawai.getRole().getIdRole());
    }
    return pegawaiDb.save(pegawai);
  }

  @Override
  public PegawaiModel getPegawaiByUuid(String uuid) {
    Optional<PegawaiModel> pegawai = pegawaiDb.findById(uuid);
    if (pegawai.isPresent()) {
      return pegawai.get();
    } else {
      throw new NoSuchElementException("Tidak ada pegawai dengan id: " + uuid);
    }
  }

  @Override
  public PegawaiModel getPegawaiByUsername(String username) {
    Optional<PegawaiModel> pegawai = pegawaiDb.findByUsername(username);
    if (pegawai.isPresent()) {
      return pegawai.get();
    } else {
      throw new NoSuchElementException("Tidak ada pegawai dengan username: " + username);
    }
  }

  @Override
  public List<PegawaiModel> getAllPegawai() {
    return pegawaiDb.findAll();
  }

  @Override
  public PegawaiModel updatePegawai(PegawaiModel pegawai) {
    PegawaiModel oldPegawai = getPegawaiByUuid(pegawai.getIdPegawai());
    oldPegawai.setAlamat(pegawai.getAlamat());
    oldPegawai.setNama(pegawai.getNama());
    oldPegawai.setNoTelepon(pegawai.getNoTelepon());
    oldPegawai.setRole(pegawai.getRole());
    oldPegawai.setTanggalLahir(pegawai.getTanggalLahir());
    oldPegawai.setTempatLahir(pegawai.getTempatLahir());
    return pegawaiDb.save(oldPegawai);
  }

}
