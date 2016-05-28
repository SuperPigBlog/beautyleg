package com.qtfreet.beautyleg.utils; /**
 * Created by qtfreet00 on 2016/5/4.
 */
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public final class DesTool {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f'};
    private static final char[] b= new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F'};

    public static String encode(String contnet, String key) throws Exception {
        Key v0 = DesTool.encode(key.getBytes());
        byte[] v1 = contnet.getBytes();
        Cipher v2 = Cipher.getInstance("DES/ECB/PKCS5Padding");
        v2.init(1, v0);
        return new String(DesTool.encode(v2.doFinal(v1), DesTool.a));
    }

    private static int encode(char arg3, int arg4) {
        int v0 = Character.digit(arg3, 16);
        if(v0 == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + arg3 + " atindex " + arg4);
        }

        return v0;
    }

    private static Key encode(byte[] arg2) throws Exception {
        return SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(arg2));
    }

    private static char[] encode(byte[] arg6, char[] arg7) {
        int v0 = 0;
        int v2 = arg6.length;
        char[] v3 = new char[v2 << 1];
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            int v4 = v0 + 1;
            v3[v0] = arg7[(arg6[v1] & 240) >>> 4];
            v0 = v4 + 1;
            v3[v4] = arg7[arg6[v1] & 15];
        }

        return v3;
    }

    public static String decode(String content, String deskey) throws Exception {
        int v0 = 0;
        Key key = DesTool.encode(deskey.getBytes());
        char[] v3 = content.toCharArray();
        int v4 = v3.length;
        if((v4 & 1) != 0) {
            throw new RuntimeException("Odd number of characters.");
        }

        byte[] v5 = new byte[v4 >> 1];
        int v1;
        for(v1 = 0; v0 < v4; ++v1) {
            int v6 = DesTool.encode(v3[v0], v0) << 4;
            ++v0;
            v6 |= DesTool.encode(v3[v0], v0);
            ++v0;
            v5[v1] = ((byte)(v6 & 255));
        }

        Cipher v0_1 = Cipher.getInstance("DES/ECB/PKCS5Padding");
        v0_1.init(2, key);
        return new String(v0_1.doFinal(v5));
    }
}

