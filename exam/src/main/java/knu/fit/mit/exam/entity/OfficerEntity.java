package knu.fit.mit.exam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "officers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int age;
    private double rating;

}
