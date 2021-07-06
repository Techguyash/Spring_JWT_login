/**
 * 
 */
package com.coma.Auth.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coma.Auth.Model.ConfirmationToken;
import com.coma.Repo.TokenRepo;



/**
 * @author tweety
 *06-Jul-2021
 */
@Service
public class ConfirmationTokenService
{	
    @Autowired
    private TokenRepo tokenRepo; 
    
    public void saveConfirmationToken(ConfirmationToken token)
    {
	tokenRepo.save(token);
    }
    
    public Optional<ConfirmationToken> getToken(String token)
    {
	return tokenRepo.findByToken(token);
    }
    public int setConfirmedAt(String token) {
        return tokenRepo.updateConfirmedAt(
                token, LocalDateTime.now());
    }

}
