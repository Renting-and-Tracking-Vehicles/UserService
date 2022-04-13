package com.example.userservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @SequenceGenerator(name = "roleSeqGen", sequenceName = "roleSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private int id;

    @Column(name="name", nullable=false)
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
