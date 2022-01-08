package com.spring.auth;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import com.spring.dao.MemberDAO;
import com.spring.dto.MemberDTO;


//시큐리티 설정에서 loginProcessingUrl("/login")
//로그인 요청이 오면 자동으로 userDetailService 타입으로 ioc 되어있는 loadUserByUsername 함수가 실행
@Component("principalDetailsService")
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
    private MemberDAO memberDAO;

    //시큐리티 session(내부 Authentication(내부 UserDetails)) =
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
      
        MemberDTO userEntity = memberDAO.findById(id);
        
       
        
       
        if(userEntity != null){
//            return new PrincipalDetails(userEntity);
            return new User(userEntity.getId(),userEntity.getPw(),AuthorityUtils.createAuthorityList(userEntity.getRole()));
        }
        return null;
    }
}
