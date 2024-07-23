package model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ChiTietComboID implements Serializable {
	@ManyToOne
	@JoinColumn(name = "maHD")
	private HoaDon hoaDon;

	@ManyToOne
	@JoinColumn(name = "maCombo")
	private ComboDoAn comboDoAn;
}
