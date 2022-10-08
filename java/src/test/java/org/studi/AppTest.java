package org.studi;

import static org.junit.Assert.assertTrue;

import org.studi.utils.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.JVM)
public class AppTest 
{

    private char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
    'w','x','y','z'};


    @Test
    public void textToVigTest(){
        int[] key = new int[]{1,3,2};
        String encrypt = Vigenere.textToVig("studi",key,alphabet);
        Assert.assertEquals("twwel",encrypt);
    }

    @Test
    public void vigToCesarTest(){
        int[] key = new int[]{1,3,2};
        String decrypt = Vigenere.vigToText("pelffvji",key,alphabet);
        Assert.assertEquals("objectif",decrypt);
    }

    @Test
    public void fileToVigTest(){
        int[] key = new int[]{1,3,2};
        Vigenere.fileToVig("testfile/testVigenere.txt",key,alphabet);
        Assert.assertEquals("twwel",Files.openFile("testfile/testVigenere_code.txt"));
    }

    @Test
    public void vigToFileTest(){
        int[] key = new int[]{1,3,2};
        Vigenere.vigToFile("testfile/testVigenere_code.txt",key,alphabet);
        Assert.assertEquals("studi",Files.openFile("testfile/testVigenere_decode.txt"));
    }

}
