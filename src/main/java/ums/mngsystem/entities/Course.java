package ums.mngsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer courseId;
    @Column
    private String name;
    @Column
    private String code;
    @Column
    private Byte enabled;
    @Column
    private Integer departmentId;
}
