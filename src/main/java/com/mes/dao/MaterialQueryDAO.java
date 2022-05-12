package com.mes.dao;

import com.mes.dto.material.MaterialDTO;
import com.mes.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MaterialQueryDAO {
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    int result;

    /*원자재 리스트*/
    public List<MaterialDTO> findAllMaterial() {
        String sql = "SELECT m.*, a.name AS accountName FROM materials m LEFT JOIN accounts a ON m.accounts_id = a.id";
        List<MaterialDTO> materialList = new ArrayList<>();
        try {
            con = DBUtil.getDataSource().getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MaterialDTO dto = new MaterialDTO();
                dto.setId(rs.getInt("id"));
                dto.setAccountId(rs.getInt("accounts_id"));
                dto.setAccountName(rs.getString("accountName"));
                dto.setNumber(rs.getString("number"));
                dto.setName(rs.getString("name"));
                dto.setTexture(rs.getString("texture"));
                dto.setSc(rs.getString("sc"));
                dto.setStandard(rs.getString("standard"));
                dto.setRm(rs.getString("rm"));
                dto.setShp(rs.getString("shp"));
                dto.setMdt(rs.getString("mdt"));
                dto.setMdw(rs.getString("mdw"));
                dto.setMl(rs.getString("ml"));
                dto.setUnit(rs.getString("unit"));
                dto.setMaker(rs.getString("maker"));
                dto.setPurchaseUnitCost(rs.getInt("purchase_unit_cost"));
                dto.setPrice(rs.getInt("price"));
                dto.setStorage1(rs.getString("storage1"));
                dto.setStorage2(rs.getString("storage2"));
                dto.setStorage3(rs.getString("storage3"));
                dto.setCreatedAt(rs.getDate("created_at"));
                dto.setUpdatedAt(rs.getDate("updated_at"));
                dto.setEtc(rs.getString("etc"));
                materialList.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(con, pstmt, rs);
        }
        return materialList;
    }

    /*원자재 등록*/
    public boolean createMaterial(MaterialDTO dto) {
        String SQL = "INSERT INTO materials (accounts_id, number, name, texture, " +
                " sc, standard, rm, shp, mdt, mdw, ml, unit, maker," +
                " puchase_unit_cost, price, storage1, storage2, storage3, etc) " +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBUtil.getDataSource().getConnection();
            pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, dto.getAccountId());
            pstmt.setString(2, dto.getNumber());
            pstmt.setString(3, dto.getName());
            pstmt.setString(4, dto.getTexture());
            pstmt.setString(5, dto.getSc());
            pstmt.setString(6, dto.getStandard());
            pstmt.setString(7, dto.getRm());
            pstmt.setString(8, dto.getShp());
            pstmt.setString(9, dto.getMdt());
            pstmt.setString(10, dto.getMdw());
            pstmt.setString(11, dto.getMl());
            pstmt.setString(12, dto.getUnit());
            pstmt.setString(13, dto.getMaker());
            pstmt.setInt(14, dto.getPurchaseUnitCost());
            pstmt.setInt(15, dto.getPrice());
            pstmt.setString(16, dto.getStorage1());
            pstmt.setString(17, dto.getStorage2());
            pstmt.setString(18, dto.getStorage3());
            pstmt.setString(19, dto.getEtc());
            result = pstmt.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(con, pstmt, rs);
        }
        return false;
    }

}
