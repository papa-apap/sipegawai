package apap.tugas.sipegawai.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "role")
public class RoleModel implements Serializable {
  @Id
  @NotNull
  @Size(max = 32, min = 32)
  @Column(name = "id", nullable = false, unique = true)
  private String idRole;

  @NotNull
  @Size(max = 200)
  @Column(name = "name", nullable = false)
  private String name;

  public String getIdRole() {
    return idRole;
  }

  public void setIdRole(String idRole) {
    this.idRole = idRole;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
