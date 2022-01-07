package com.spring.auth;

//시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행
//로그인을 진행이 완료가 되면 시큐리티 session 을 만들어준다(Security ContextHolder)
// 오브젝트 => Authentication 안에 User 정보가 있어야됨
//User 오브젝ㄱ트타입 => UserDetails 타입 객체

//Security Session => Authentication => UserDetails


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.dto.MemberDTO;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class PrincipalDetails implements UserDetails {

    private MemberDTO memberDTO;

    public PrincipalDetails( MemberDTO memberDTO){
        this.memberDTO = memberDTO;
    }

    //해당 User 의 권한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return memberDTO.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return memberDTO.getPw();
    }

    @Override
    public String getUsername() {
        return memberDTO.getId();
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
