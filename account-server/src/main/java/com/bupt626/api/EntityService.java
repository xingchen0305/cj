package com.bupt626.api;

import com.bupt626.entity.Account;
import com.bupt626.entity.Address;
import com.bupt626.entity.Star;
import com.bupt626.repository.AccountRepository;
import com.bupt626.repository.AddressRepository;
import com.bupt626.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by i-hexiuyu on 2017/7/17.
 */
@Service
public class EntityService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private StarRepository starRepository;

    public Account findAccount(String accountName){
        return accountRepository.findOne(accountName);
    }

    public void saveAccount(Account account){
        accountRepository.save(account);
    }

    public Address findAddress(Long id){
        return addressRepository.findOne(id);
    }

    public void deleteAddress(Long id){
        addressRepository.delete(id);
    }

    public void saveAddress(Address address){
        addressRepository.save(address);
    }

    public void saveStar(Star star) {
        starRepository.save(star);
    }

    public Star findStar(Long id) {
        return starRepository.findOne(id);
    }

    public void deleteStar(Long id) {
        starRepository.delete(id);
    }
}
