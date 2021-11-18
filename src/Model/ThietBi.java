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
public class ThietBi implements Serializable {
    private int maTB;
    private String tenTB;
    private String XuatXu;
    private int NamSX;
    private static int currentID = 10000;

    public ThietBi() {
        maTB = currentID++;
    }

    public ThietBi(int maTB, String tenTB, String XuatXu, int NamSX) {
        this.maTB = maTB;
        this.tenTB = tenTB;
        this.XuatXu = XuatXu;
        this.NamSX = NamSX;
    }

    public int getMaTB() {
        return maTB;
    }

    public void setMaTB(int maTB) {
        this.maTB = maTB;
    }

    public String getTenTB() {
        return tenTB;
    }

    public void setTenTB(String tenTB) {
        this.tenTB = tenTB;
    }

    public String getXuatXu() {
        return XuatXu;
    }

    public void setXuatXu(String XuatXu) {
        this.XuatXu = XuatXu;
    }

    public int getNamSX() {
        return NamSX;
    }

    public void setNamSX(int NamSX) {
        this.NamSX = NamSX;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        ThietBi.currentID = currentID;
    }
    
    public Object[] toObjects() {
        return new Object[] {
            maTB, tenTB, XuatXu, NamSX
        };
    }
}
