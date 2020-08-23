/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.wecare.doctor.channel.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** @author macbook */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Booking implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer bookingNo;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "fkDoctor", referencedColumnName = "id")
  private Doctor fkDoctor;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "fkSession", referencedColumnName = "id")
  private DoctorSession fkSession;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "fkCustomer", referencedColumnName = "id")
  private Customer fkCustomer;

  private Date createdDateTime;
}
