package com.isc.ipnew.model;

import com.isc.ipnew.dao.dto.UserDTO;

import java.util.List;

public class UserListResponse {

    private List<UserDTO> models;

    public UserListResponse(List<UserDTO> models) {
        this.models = models;
    }

    public List<UserDTO> getModels() {
        return models;
    }

    public void setModels(List<UserDTO> models) {
        this.models = models;
    }
}
