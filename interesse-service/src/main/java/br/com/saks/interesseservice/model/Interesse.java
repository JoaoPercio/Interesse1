package br.com.saks.interesseservice.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data

public class Interesse {
    
    @EmbeddedId
    InteresseIdentity interesseIdentity;
    
}
