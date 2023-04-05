package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate cratedDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    public Payment(LocalDate cratedDate, BigDecimal amount, Status paymentStatus) {
        this.cratedDate = cratedDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }


}
