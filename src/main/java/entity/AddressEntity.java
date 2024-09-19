package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name="address",schema = "bank")
@Entity
@Data
public class AddressEntity {
    public AddressEntity(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer id;

    @Column(name = "state")
    public String State;


    @ManyToOne
    @JoinColumn(name = "aadharNumber",referencedColumnName = "aadharNumber")
    public AadharEntity myMappedByTestEntity;
}
