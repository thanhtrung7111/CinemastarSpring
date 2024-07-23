package model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinhLuanID implements Serializable{
	private TaiKhoan taiKhoan;
	private Phim phim;
}
