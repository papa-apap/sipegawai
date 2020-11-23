package apap.tugas.sipegawai.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tugas.sipegawai.model.PegawaiModel;
import apap.tugas.sipegawai.repository.PegawaiDb;

@Service
@Transactional
public class PegawaiRestServiceImpl implements PegawaiRestService {
  @Autowired
  private PegawaiDb pegawaiDb;

  @Override
  public PegawaiModel createPegawai(PegawaiModel pegawai) {
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
    Optional<PegawaiModel> pegawai = pegawaiDb.findById(username);
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
