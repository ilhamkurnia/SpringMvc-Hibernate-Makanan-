package com.springmvc.hibernate.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name= "tb_makanan")
public class Makanan implements Serializable {

    @Id
    @Column(name = "id_makanan", length = 150)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "System-uuid", strategy ="uuid")
    private String idMakanan;

    @Column(name = "namaMakanan", length= 40)
    private String namaMakanan;

    @Column(name = "hargaMakanan")
    private BigDecimal hargaMakanan;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "tanggalKadaluarsa")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalKadaluarsa;
}
