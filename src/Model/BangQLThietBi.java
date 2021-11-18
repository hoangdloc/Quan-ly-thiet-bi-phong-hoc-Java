/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Hoang Loc
 */
public class BangQLThietBi implements Serializable {
    private ThietBi thiet_bi;
    private PhongHoc phong_hoc;
    private int soLuong;
    private String tinhTrang;

    public BangQLThietBi() {
    }

    public BangQLThietBi(ThietBi thiet_bi, PhongHoc phong_hoc, int soLuong, String tinhTrang) {
        this.thiet_bi = thiet_bi;
        this.phong_hoc = phong_hoc;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public ThietBi getThiet_bi() {
        return thiet_bi;
    }

    public void setThiet_bi(ThietBi thiet_bi) {
        this.thiet_bi = thiet_bi;
    }

    public PhongHoc getPhong_hoc() {
        return phong_hoc;
    }

    public void setPhong_hoc(PhongHoc phong_hoc) {
        this.phong_hoc = phong_hoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    public Object[] toObjects() {
        return new Object[] {
            phong_hoc.getMaPH(), phong_hoc.getTenPH(), thiet_bi.getTenTB(), thiet_bi.getMaTB(), soLuong, tinhTrang
        };
    }
}
