package it.beije.makemake.ecommerce;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "\"Order\"")
public class Order {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		
		@Column
		private LocalDateTime date;
		
		@Column
		private Integer id_user;
		
		@Column
		private String status;
		
		@Column
		private double total;

		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		
		
		public LocalDateTime getDate() {
			return date;
		}
		public void setDate(LocalDateTime date) {
			this.date = date;
		}
		
		
		public Integer getIduser() {
			return id_user;
		}		
		public void setIduser(Integer id_user) {
			this.id_user = id_user;
		}
		
		
		public String getStatus() {
			return status;
		}		
		public void setStatus(String status) {
			this.status = status;
		}
		
		
		public double getTotal() {
			return total;
		}		
		public void setTotal(double total) {
			this.total = total;
		}
}
