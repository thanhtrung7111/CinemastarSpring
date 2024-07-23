package model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThamGiaID implements Serializable{

	private DienVienDaoDien dienVienDaoDien;
	private Phim phim;
}
