package com.mes.service;

import com.mes.dao.AccountDAO;
import com.mes.dao.MaterialDAO;
import com.mes.dao.MaterialQueryDAO;
import com.mes.dto.material.MaterialDTO;
import com.mes.entity.Account;
import com.mes.entity.Material;
import com.mes.exception.NotFoundEntityException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialService {

    private final HttpServletRequest request;
    private MaterialQueryDAO materialQueryDAO = new MaterialQueryDAO();
    private MaterialDAO materialDao = new MaterialDAO();
    private AccountDAO accountDAO = new AccountDAO();

    public MaterialService(HttpServletRequest request) {
        this.request = request;
    }

    private void materialField(Material material, MaterialDTO dto) {
        material.getAccount().setId(dto.getAccountId());
        material.setNumber(dto.getNumber());
        material.setName(dto.getName());
        material.setTexture(dto.getTexture());
        material.setSc(dto.getSc());
        material.setShp(dto.getShp());
        material.setMdt(dto.getMdt());
        material.setMdw(dto.getMdw());
        material.setMl(dto.getMl());
        material.setUnit(dto.getUnit());
        material.setMaker(dto.getMaker());
        material.setPurchaseUnitCost(dto.getPurchaseUnitCost());
        material.setPrice(dto.getPrice());
        material.setStorage1(dto.getStorage1());
        material.setStorage2(dto.getStorage2());
        material.setStorage3(dto.getStorage3());
        material.setEtc(dto.getEtc());
    }

    public void deleteMaterial(String ids) {
        Integer selectIds = Integer.valueOf(ids);
        materialDao.delete(selectIds);
    }

    public boolean findAll() {
        List<MaterialDTO> materialList = materialQueryDAO.findAllMaterial();
        if (materialList != null) {
            request.setAttribute("materialList", materialList);
            return true;
        }
        return false;
    }

//    public List<Material> findAll() {
//        List<Object[]> result = materialDao.findAll();
//        List<Material> materialList = new ArrayList<>();
//        for (Object[] val : result) {
//            Account account = (Account) val[1];
//            Material material = (Material) val[0];
//            if (account != null) {
//                material.setAccount(account);
//            }
//            materialList.add(material);
//        }
//        if (materialList == null || materialList.isEmpty()) {
//            request.setAttribute("message", "리스트 조회 실패");
//            request.setAttribute("target", "javascript:history.back()");
//        }
//        long materialTotalCount = materialDao.countAll();
//        request.setAttribute("materialList", materialList);
//        request.setAttribute("total", materialTotalCount);
//        return materialList;
//    }

    //원자재 정보관리 리스트 출력
//    public List<Material> findAllCreateSql() {
//        List<Object[]> result = materialDao.findAllCreateSql();
//        List<Material> materialList = new ArrayList<>();
//        for (Object[] val : result) {
//            Material material = (Material) val[0];
//            Account account = (Account) val[1];
//            material.setAccount(account);
//            materialList.add(material);
//        }
//        if (materialList == null || materialList.isEmpty()) {
//            request.setAttribute("message", "리스트 조회 실패");
//            request.setAttribute("target", "javascript:history.back()");
//        }
//        request.setAttribute("materialList", materialList);
//        return materialList;
//    }

    //원자재 정보 등록
    public boolean createMaterial(MaterialDTO dto) {
        boolean result = materialQueryDAO.createMaterial(dto);
        if (result) {
            request.setAttribute("message", "등록 성공했습니다.");
        } else {
            request.setAttribute("message", "등록 실패했습니다.");
        }
        return result;
    }

    public boolean insertMaterial(MaterialDTO dto) {
        Integer accountId = dto.getAccountId();
        Account account = accountDAO.find(accountId);
        System.out.println(account.getId());
        Material material = new Material(account);
        materialField(material, dto);
        materialDao.create(material);
        return true;
    }

    public Material findMaterialById(Object id, Object accountName) {
        Material material = materialDao.find(id);
        if (material != null) {
            request.setAttribute("material", material);
            request.setAttribute("accountName", accountName);
            System.out.println("찾은 자재의 거래처명 : " + accountName);
        }
        return material;
    }
}
