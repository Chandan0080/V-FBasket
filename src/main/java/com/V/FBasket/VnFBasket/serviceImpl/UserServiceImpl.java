package com.V.FBasket.VnFBasket.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.V.FBasket.VnFBasket.jpaRepository.UserRepository;
import com.V.FBasket.VnFBasket.model.User;
import com.V.FBasket.VnFBasket.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepo;

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
    public User createUser(User user) {
        try{
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
    public void deleteUser(Long id) {
        try{
            userRepo.deleteById(id);
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
