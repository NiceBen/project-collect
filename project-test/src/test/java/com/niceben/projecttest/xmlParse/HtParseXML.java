package com.niceben.projecttest.xmlParse;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Base64;

public class HtParseXML {

    static String inPath = "E:\\tmp\\abc.ht";
    @Test
    public void test2() throws Exception {
        final Base64.Decoder decoder = Base64.getDecoder();

        InputStream input=new FileInputStream(inPath);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024*4];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        byte[] bytes = output.toByteArray();

        //解码
        System.out.println(new String(decoder.decode(bytes), "UTF-8"));
        input.close();
    }
}
