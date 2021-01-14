package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.SingleUser;
import pl.coderslab.charity.repository.SingleUserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerUserDetailsService implements UserDetailsService {

    private final SingleUserRepository singleUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("Searching for user by email '{}'", email);

        if (!singleUserRepository.existsByEmail(email)) {
            throw new UsernameNotFoundException(String.format("Username %s not found", email));
        }
        final SingleUser users = singleUserRepository.getByEmail(email);
        UserDetails user = User.withUsername(users.getEmail()).password(users.getPassword()).authorities(users.getUsersRoles().getRole()).build();
        return user;



//        return new User(
//                users.getEmail()
//                , users.getPassword()
//                , Collections.singletonList(new SimpleGrantedAuthority(users.getUsersRoles().getRole())));


//        users.getUsername()
//                , users.getPassword()
//                , Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }

}
