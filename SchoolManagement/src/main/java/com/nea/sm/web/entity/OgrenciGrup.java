package com.nea.sm.web.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="ogrenci_grup")
@EqualsAndHashCode(callSuper = false)
@Data
public class OgrenciGrup {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "seq_ogrenci_grup", allocationSize = 1, sequenceName = "seq_ogrenci_grup")
	@GeneratedValue(generator = "seq_ogrenci_grup", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ogrenci_id")
	private Ogrenci ogrenci;
	
	@ManyToOne
	@JoinColumn(name = "grup_id")
	private YonetimGrup grup;
	
	@Column(name="ucret")
	private BigDecimal ucret;
	
	@Column(name="kay�t_tarihi")
	@Temporal(TemporalType.DATE)
	private Date kay�tTarihi;
	
	
	@Override
    public boolean equals(Object obj) {
    	if(obj instanceof OgrenciGrup){
    		if(((OgrenciGrup)obj).getId().equals(this.id)){
    			return true;
    		}
    	}
    	return false;
    }
	
	

}
