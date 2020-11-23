package apap.tugas.sipegawai.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tugas.sipegawai.model.RoleModel;
import apap.tugas.sipegawai.repository.RoleDb;

@Service
@Transactional
public class RoleRestServiceImpl implements RoleRestService {
  @Autowired
  private RoleDb roleDb;

  @Override
  public RoleModel creatRole(RoleModel role) {
    return roleDb.save(role);
  }

  @Override
  public RoleModel getRoleByUuid(String uuid) {
    Optional<RoleModel> role = roleDb.findById(uuid);
    if (role.isPresent()) {
      return role.get();
    } else {
      throw new NoSuchElementException("Tidak ada role dengan id: " + uuid);
    }
  }

}
