package ums.mngsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ums.mngsystem.enums.Roles;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer userId;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private Byte enabled;

    private Roles roles;

}
