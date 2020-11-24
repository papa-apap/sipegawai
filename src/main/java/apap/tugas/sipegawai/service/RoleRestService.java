package apap.tugas.sipegawai.service;

import apap.tugas.sipegawai.model.RoleModel;

public interface RoleRestService {
  RoleModel creatRole(RoleModel role);

  RoleModel getRoleById(Long id);
}
