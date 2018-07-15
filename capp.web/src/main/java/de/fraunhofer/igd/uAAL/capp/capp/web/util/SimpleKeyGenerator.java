package de.fraunhofer.igd.uAAL.capp.capp.web.util;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
public class SimpleKeyGenerator implements KeyGenerator{

	public Key generateKey() {
        String keyString = "universAALkey";
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
        return key;
    }
}
