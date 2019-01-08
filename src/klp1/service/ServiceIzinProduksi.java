/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klp1.service;

import java.sql.SQLException;
import java.util.ArrayList;
import klp1.entity.IzinProduksi;

/**
 *
 * @author sofyan
 */
public interface ServiceIzinProduksi {
    
    public void createIzinProduksi(IzinProduksi s) throws SQLException;
    public void updateIzinProduksi(IzinProduksi s) throws SQLException;
    public void deleteIzinProduksi(IzinProduksi s) throws SQLException;
    public IzinProduksi getIzinProduksiById(String id) throws SQLException;
    public ArrayList<IzinProduksi> getIzinProduksi() throws SQLException;
    
}
