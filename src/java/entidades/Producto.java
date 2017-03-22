/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author martaperal
 */
public class Producto {

    private int id;
    private String concepto;
    private double importe;
    
    public Producto(int id, String concepto, double importe) {
        super();
        this.id = id;
        this.concepto = concepto;
        this.importe = importe;
    }

    public Producto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

  

}
