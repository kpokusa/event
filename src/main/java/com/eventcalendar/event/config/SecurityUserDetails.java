package com.eventcalendar.event.config;

/*Wrapper class for our domain users - needed to expose security contract
to Spring Security.
This is to decouple/translate domain credentials to obligatory spring credentials
(which are username + password).

*/

import com.eventcalendar.event.persistance.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityUserDetails extends User implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return AuthorityUtils.createAuthorityList("ROLE_USER");
        return AuthorityUtils.createAuthorityList(getRole());
    }

    public SecurityUserDetails(User user) {
        super(user);
    }

    @Override
    public String getUsername() {
        return getFirstName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}