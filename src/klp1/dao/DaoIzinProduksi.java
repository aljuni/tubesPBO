/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import klp1.config.Koneksi;
import klp1.entity.IzinProduksi;
import klp1.service.ServiceIzinProduksi;

/**
 *
 * @author sofyan
 */
public class DaoIzinProduksi implements ServiceIzinProduksi {
    
    private Connection connection;
    
    public DaoIzinProduksi() throws SQLException{
        connection = Koneksi.getConnection();
    }
    
//    @Override
    public void createIzinProduksi(IzinProduksi s) throws SQLException{
        PreparedStatement st = null;
        String sql = "INSERT INTO tablesurat VALUE(?,?,?,?)";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, s.getId());
            st.setString(2, s.getNama_barang());
            st.setString(3, s.getNama_perusahaan());
            st.setString(4, s.getAlamat());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null){
                st.close();
            }
        }
    }
    
//    @Override
    public void updateIzinProduksi(IzinProduksi s) throws SQLException{
        PreparedStatement st = null;
        String sql = "UPDATE tablesurat SET nama_barang=?, nama_perusahaan=?, alamat=? where id=?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(4, s.getId());
            st.setString(1, s.getNama_barang());
            st.setString(2, s.getNama_perusahaan());
            st.setString(3, s.getAlamat());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
        if (st != null){
            st.close();
        }
    }
   }
    
//    @Override
    public void deleteIzinProduksi(IzinProduksi s) throws SQLException {
        PreparedStatement st = null;
        String sql = "DELETE FROM tablesurat WHERE id=?";
        
        try {
            st = connection.prepareCall(sql);
            st.setString(1, s.getId());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
//    @Override
    public IzinProduksi getIzinProduksiById(String id) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        IzinProduksi s = null;
        String sql = "SELECT * FROM tablesurat WHERE id=?";
        
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                s = new IzinProduksi();
                s.setId(rs.getString("id"));
                s.setNama_barang(rs.getString("nama_barang"));
                s.setNama_perusahaan(rs.getString("nama_perusahaan"));
                s.setAlamat(rs.getString("alamat"));
            }
            return s;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null){
                st.close();
            }
            if (rs != null){
                rs.close();
            }
        }
    }
    
//    @Override
    public ArrayList<IzinProduksi> getIzinProduksi() throws SQLException {
        PreparedStatement st = null;
        ArrayList<IzinProduksi> listIzinProduksi = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM tablesurat";
        
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                IzinProduksi s = new IzinProduksi();
                s.setId(rs.getString("id"));
                s.setNama_barang(rs.getString("nama_barang"));
                s.setNama_perusahaan(rs.getString("nama_perusahaan"));
                s.setAlamat(rs.getString("alamat"));
                
                listIzinProduksi.add(s);
            }
            return listIzinProduksi;
        } catch (SQLException e) {
            throw e;
        } finally {
            if(st != null){
                st.close();
            }
            if (rs != null){
                rs.close();
            }
        }
    }
    
}
