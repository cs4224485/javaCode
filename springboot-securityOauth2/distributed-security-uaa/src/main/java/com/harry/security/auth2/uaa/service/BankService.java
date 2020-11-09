package com.harry.security.auth2.uaa.service;

import com.harry.security.auth2.uaa.model.UserDto;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.security.access.prepost.PreAuthorize;

public interface BankService {
    @PreAuthorize("isAnonymous()")
    public UserDto redUser(Long id);

    @PreAuthorize("hasAuthority('p_transfer') and hasAuthority('p_read_account')")
    public UserDto post(Long id);
}
