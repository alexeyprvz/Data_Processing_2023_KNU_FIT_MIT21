package knu.fit.mit.lab.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="granades")
public class GrndEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private String img;
    private Integer weight;
}