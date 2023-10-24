/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrify.entities;

/**
 *
 * @author alien kami sama
 */
public class DataPoint {
    private String time;
    private double quantity;

    public DataPoint(String time, double quantity) {
        this.time = time;
        this.quantity = quantity;
    }

    public String getTime() {
        return time;
    }

    public double getQuantity() {
        return quantity;
    }
}
