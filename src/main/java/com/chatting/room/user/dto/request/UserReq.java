package com.chatting.room.user.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReq {

    private String username;
    private String password;
    private String description;
}
