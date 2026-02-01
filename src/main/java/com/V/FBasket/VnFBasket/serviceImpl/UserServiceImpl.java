package com.V.FBasket.VnFBasket.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.V.FBasket.VnFBasket.config.UserInfoUserDetails;
import com.V.FBasket.VnFBasket.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.V.FBasket.VnFBasket.jpaRepository.UserRepository;
import com.V.FBasket.VnFBasket.model.User;
import com.V.FBasket.VnFBasket.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long id) {
        try{
            return userRepo.findById(id).orElse(null);
        } catch(Exception e){
            e.printStackTrace();}
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        try{
            return userRepo.findAll();
        } catch(Exception e){
            
                e.printStackTrace();
        }
        return null;
    }

    @Override
    public User registerUser(User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepo.save(user);
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {
        try{

        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        try{
            Optional<User> opt = userRepo.findById(id);
            if (opt.isEmpty()) return false;
            userRepo.deleteById(id);
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
    }

    @Override
    public List<User> getUsersByRole(String role) {

        return userRepo.findByRole(role);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         Optional<User> userInfo = userRepo.findByEmail(email);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).get();
    }

    @Override
    public boolean checkUserExistsByEmail(String email) {
        return userRepo.existsUserByEmail(email);
    }

}
