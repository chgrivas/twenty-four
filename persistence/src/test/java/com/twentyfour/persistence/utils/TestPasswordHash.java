package com.twentyfour.persistence.utils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPasswordHash {
    
    @Test
    public void testCorrectPassword() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String hash = PasswordHash.createHash("12345");
        Assert.assertTrue(PasswordHash.validatePassword("12345", hash));
    }
    
    @Test
    public void testIncorrectPassword() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String hash = PasswordHash.createHash("12345");
        Assert.assertFalse(PasswordHash.validatePassword("12344", hash));
    }

}
