package model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApDungTaiKhoanID implements Serializable{
	private KhuyenMai khuyenMai;
	private LoaiTaiKhoan loaiTaiKhoan;
}
