/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klp1.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import klp1.entity.IzinProduksi;

/**
 *
 * @author sofyan
 */
public class TableModelIzinProduksi extends AbstractTableModel {
    
    private ArrayList<IzinProduksi> listIzinProduksi = new ArrayList<>();
    
//    @Override
    public int getRowCount(){
        return listIzinProduksi.size();
    }
    
//    @Override
    public int getColumnCount(){
        return 4;
    }
    
//    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0: return listIzinProduksi.get(rowIndex).getId();
            case 1: return listIzinProduksi.get(rowIndex).getNama_barang();
            case 2: return listIzinProduksi.get(rowIndex).getNama_perusahaan();
            case 3: return listIzinProduksi.get(rowIndex).getAlamat();
            default: return null;
        }
    }
    
    
//    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id Surat";
            case 1: return "Nama Barang";
            case 2: return "Nama Perusahaan";
            case 3: return "Alamat";
            default: return null;
        }
    }
    
    public void createIzinProduksi(IzinProduksi s){
        listIzinProduksi.add(s);
        fireTableDataChanged();
    }
    
    public void updateIzinProduksi(int index, IzinProduksi s){
        listIzinProduksi.set(index,s);
        fireTableDataChanged();
    }
    
    public void deleteIzinProduksi(int index){
        listIzinProduksi.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(ArrayList<IzinProduksi> listIzinProduksi){
        this.listIzinProduksi = listIzinProduksi;
        fireTableDataChanged();
    }
    
    public IzinProduksi getIzinProduksi(int index) {
        return listIzinProduksi.get(index);
    }
    
    public void clear(){
        listIzinProduksi.clear();
    }
    
}
