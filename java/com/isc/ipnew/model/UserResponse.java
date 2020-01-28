package com.isc.ipnew.model;

import com.isc.ipnew.dao.dto.UserDTO;


public class UserResponse {
    private UserDTO model;

    public UserResponse(UserDTO model) {
        this.model = model;
    }

    public UserDTO getModel() {
        return model;
    }

    public void setModel(UserDTO model) {
        this.model = model;
    }
}
