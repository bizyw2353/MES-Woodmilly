package com.mes.service;

import com.mes.dao.UserDAO;
import com.mes.dto.LoginDTO;
import com.mes.dto.SearchKeyWordDTO;
import com.mes.dto.UserDTO;
import com.mes.entity.User;
import com.mes.exception.FailServiceException;
import com.mes.exception.NotFoundEntityException;

import java.util.HashMap;
import java.util.List;


public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User join(UserDTO userDTO) throws FailServiceException {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());

        User result = userDAO.create(user);
        if (result == null) {
            throw new FailServiceException("회원가입 실패");
        }
        return result;
    }

    public boolean userIdCheck(String userId) {
        return userDAO.checkByUserId(userId);
    }

    public boolean login(LoginDTO loginDTO) throws FailServiceException {
        boolean result = userDAO.checkLogin(loginDTO.getUserId(), loginDTO.getPassword());

        if (!result) {
            throw new FailServiceException("로그인 실패. 아이디와 비밀번호를 확인해주세요");
        }
        return result;
    }

    public List<User> userList(SearchKeyWordDTO searchKeywordDto) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("userId", searchKeywordDto.getUserId());
        map.put("name", searchKeywordDto.getName());
        return userDAO.searchWithQuery("User", map);
    }

    public User findUserById(Object id) throws NotFoundEntityException {
        User result = userDAO.find(id);

        if (result == null) {
            throw new NotFoundEntityException("유저 조회에 실패했습니다. 존재하지 않는 유저입니다.");
        }
        return result;
    }

    public User updateUser(UserDTO userDto) throws FailServiceException {
        User user = new User();
        user.setId(userDto.getId());
        user.setUserId(userDto.getUserId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());

        User result = userDAO.update(user);
        if (result == null) {
            throw new FailServiceException("유저정보 수정에 실패 했습니다.");
        }
        return result;
    }

}
