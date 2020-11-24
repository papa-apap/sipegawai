package apap.tugas.sipegawai.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "role")
public class RoleModel implements Serializable {
  @Id
  @NotNull
  @Column(name = "id", nullable = false, unique = true)
  private Long idRole;

  @NotNull
  @Size(max = 200)
  @Column(name = "name", nullable = false)
  private String name;


  @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<PegawaiModel> listPegawai;

  public Long getIdRole() {
    return idRole;
  }

  public void setIdRole(Long idRole) {
    this.idRole = idRole;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
