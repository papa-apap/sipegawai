package apap.tugas.sipegawai.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "pegawai")
public class PegawaiModel implements Serializable {
  @Id
  @NotNull
  @Size(max = 32, min = 32)
  @Column(name = "uuid", nullable = false, unique = true)
  private String idPegawai;

  @NotNull
  @Size(max = 200)
  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @NotNull
  @Size(max = 200)
  @Column(name = "nama", nullable = false)
  private String nama;

  @NotNull
  @Size(max = 200)
  @Column(name = "no_telepon", nullable = false)
  private String noTelepon;

  @NotNull
  @Size(max = 200)
  @Column(name = "tempat_lahir", nullable = false)
  private String tempatLahir;

  @NotNull
  @Column(name = "tanggal_lahir", nullable = false)
  private Date tanggalLahir;

  @NotNull
  @Size(max = 200)
  @Column(name = "alamat", nullable = false)
  private String alamat;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "id_role", referencedColumnName = "id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private RoleModel role;

  public String getIdPegawai() {
    return idPegawai;
  }

  public void setIdPegawai(String idPegawai) {
    this.idPegawai = idPegawai;
  }

  public String getAlamat() {
    return alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getNoTelepon() {
    return noTelepon;
  }

  public void setNoTelepon(String noTelepon) {
    this.noTelepon = noTelepon;
  }

  public RoleModel getRole() {
    return role;
  }

  public void setRole(RoleModel role) {
    this.role = role;
  }

  public Date getTanggalLahir() {
    return tanggalLahir;
  }

  public void setTanggalLahir(Date tanggalLahir) {
    this.tanggalLahir = tanggalLahir;
  }

  public String getTempatLahir() {
    return tempatLahir;
  }

  public void setTempatLahir(String tempatLahir) {
    this.tempatLahir = tempatLahir;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
