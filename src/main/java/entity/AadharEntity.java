package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name="aadhar",schema = "bank")
@Entity
@Data
public class AadharEntity {
    public  AadharEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aadharnumber")
    public Integer aadharNumber;

    @Column(name = "name")
    public String name;

    @OneToMany(mappedBy = "myMappedByTestEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    public List<AddressEntity> addressEntityList;




}

