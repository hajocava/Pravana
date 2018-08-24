/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author hajoc
 */
public class ImageRender extends DefaultTableCellRenderer{
    
    private Component componente;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        int liquidez = Integer.parseInt(table.getValueAt(row, 3).toString());
        
        if(liquidez == 1){
            componente.setBackground(new java.awt.Color(225, 239, 222));
        }else if(liquidez == 0){
            componente.setBackground(new java.awt.Color(255, 255, 255));
        }
        
        if(isSelected){
            componente.setBackground(new java.awt.Color(216, 238, 243));
        }
        
        return componente;
    }
    
}
