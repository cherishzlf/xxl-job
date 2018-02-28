     package com.xxl.job.executor.utils;

     import java.security.MessageDigest;
     import java.security.NoSuchAlgorithmException;

     public class Encrypt
     {
       public static String encrypt(String strSrc, String encName)
       {
       MessageDigest md = null;
       String strDes = null;
         
       byte[] bt = strSrc.getBytes();
         try
         {
         if ((encName == null) || (encName.equals(""))) {
           encName = "SHA-256";
           }
         md = MessageDigest.getInstance(encName);
         md.update(bt);
         strDes = bytes2Hex(md.digest());
         }
         catch (NoSuchAlgorithmException e)
         {
         return null;
         }
       return strDes.toUpperCase();
       }
       
       public static String bytes2Hex(byte[] bts)
       {
       String des = "";
       String tmp = null;
       for (int i = 0; i < bts.length; i++)
         {
        tmp = Integer.toHexString(bts[i] & 0xFF);
        if (tmp.length() == 1) {
           des = des + "0";
           }
         des = des + tmp;
         }
       return des;
       }
     }


