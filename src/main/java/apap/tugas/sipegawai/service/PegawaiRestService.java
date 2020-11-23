package apap.tugas.sipegawai.service;

import java.util.List;

import apap.tugas.sipegawai.model.PegawaiModel;

public interface PegawaiRestService {
  PegawaiModel createPegawai(PegawaiModel pegawai);

  PegawaiModel getPegawaiByUuid(String uuid);

  PegawaiModel getPegawaiByUsername(String username);

  List<PegawaiModel> getAllPegawai();

  PegawaiModel updatePegawai(PegawaiModel pegawai);
}
