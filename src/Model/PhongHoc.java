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
public class PhongHoc implements Serializable {
    private int maPH;
    private String tenPH;
    private int soGhe;
    private static int currentID = 10000;

    public PhongHoc() {
        maPH = currentID++;
    }

    public PhongHoc(int maPH, String tenPH, int soGhe) {
        this.maPH = maPH;
        this.tenPH = tenPH;
        this.soGhe = soGhe;
    }

    public int getMaPH() {
        return maPH;
    }

    public void setMaPH(int maPH) {
        this.maPH = maPH;
    }

    public String getTenPH() {
        return tenPH;
    }

    public void setTenPH(String tenPH) {
        this.tenPH = tenPH;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        PhongHoc.currentID = currentID;
    }
    
    public Object[] toObjects() {
        return new Object[] {
            maPH, tenPH, soGhe
        };
    }
}
