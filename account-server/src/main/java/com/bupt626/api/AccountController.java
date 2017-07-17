package com.bupt626.api;

import com.bupt626.entity.Account;
import com.bupt626.entity.Address;
import com.bupt626.entity.Star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.security.Principal;
import java.util.*;

/**
 * Created by i-hexiuyu on 2017/7/17.
 */
@RestController
public class AccountController {
    @Autowired
    private EntityService entityService;

    @GetMapping("/")
    public ResponseEntity getAccount(Principal principal) throws Exception {
        String username = principal.getName();
        return Optional.ofNullable(entityService.findAccount(username))
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElseThrow(() ->new Exception(String.format("can't findAccount %s's account", username)));
    }

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity crateAccount(@RequestBody Account account, Principal principal){
        String username = principal.getName();
        account.setAccountName(username);
        if(entityService.findAccount(username)!=null){
            return new ResponseEntity("account has exist,cant create annother one", HttpStatus.BAD_REQUEST);
        }

        Set<Star> stars = account.getStars();
        Set<Address> addresses = account.getAddresses();
        if(stars !=null){
            stars.forEach(star -> {
                star.setAccount(account);
                star.setStarTime(new Date());
            });
        }
        if (addresses != null) {
            addresses.forEach(address -> address.setAccount(account));
        }
        entityService.saveAccount(account);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "address", method = RequestMethod.POST)
    public ResponseEntity addAddress(@RequestBody Address address, Principal principal) {
        String username = principal.getName();
        address.setAccount(entityService.findAccount(username));
        entityService.saveAddress(address);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "address/{address_id}",method = RequestMethod.DELETE)
    public ResponseEntity removeAddress(@PathVariable("address_id") Long addressId,Principal principal){
        String username = principal.getName();
        Address address = entityService.findAddress(addressId);
        if(address!=null){
            if(address.getAccount().getAccountName().equals(username)){
                entityService.deleteAddress(addressId);
            }
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "star", method = RequestMethod.POST)
    public ResponseEntity addStar(@RequestBody Star star, Principal principal) {
        String username = principal.getName();
        star.setStarTime(new Date());
        Account account = entityService.findAccount(username);
        if(account.getStars() == null || !account.getStars().contains(star)){
            star.setAccount(account);
            entityService.saveStar(star);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity("already star this commodity", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "star/{star_id}",method = RequestMethod.DELETE)
    public ResponseEntity removeStar(@PathVariable("star_id") Long starId, Principal principal){
        String username = principal.getName();
        Star star = entityService.findStar(starId);
        if(star!=null){
            if(star.getAccount().getAccountName().equals(username)){
                entityService.deleteStar(starId);
            }
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
