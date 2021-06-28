package com.company.springSecurity.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table
@Data
//@Setter
//@Getter
//@NoArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String role;

    @Override
    public String getAuthority() {
        return role;
    }
}