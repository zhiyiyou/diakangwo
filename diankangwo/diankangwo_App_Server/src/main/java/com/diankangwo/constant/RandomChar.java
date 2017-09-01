package com.diankangwo.constant;

import java.util.Random;

/**
 * 产生随机字母
 * @author xiaoyu
 *
 */
public class RandomChar {
    //a-z 97-122
    //A-Z 65-90
    public static char createUpper(){
        Random uppercaserad = new Random();
        char uppercase = (char) (65 + uppercaserad.nextInt(26));
        return uppercase;
    }
     
    public static char createLower(){
        Random lowercaseintrad = new Random();
        char lowercase = (char) (97 + lowercaseintrad.nextInt(26));
        return lowercase;
    }

}

