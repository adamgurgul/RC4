package krypto22;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Test {

	public static void main(String[] args) throws Exception{
		File file = new File("kryptogram.txt");
		Scanner scanner = new Scanner(file);
		String dane = scanner.useDelimiter("\\A").next();
		scanner.close();

		dane = dane.replace("\n", " ").replace("\r", "");
		int len = dane.split(" ").length;
		String[] daneTab = dane.split(" ");
		byte[] cipherText = new byte[len];
		for (int i=0; i < len; i++) {
			cipherText[i] = (byte)Integer.parseInt(daneTab[i], 2);
		}
		PrintWriter pw = new PrintWriter("odszyfrowaneLukasz.txt");
		String k0 = "";
		String k1 = "";
		String k2 = "";
		String k3 = "";
		String k4 = "";
		String k5 = "";
		String k6 = "";
		String k7 = "";
		
		for (int i = 10; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				for (int k = 0; k < 16; k++) {
					for (int l = 0; l < 16; l++) {
						for (int m = 0; m < 16; m++) {
							for (int n = 0; n < 16; n++) {
								for (int o = 0; o < 16; o++) {
									for (int p = 0; p < 16; p++) {
										k0 = Integer.toHexString(i);
										k1 = Integer.toHexString(j);
										k2 = Integer.toHexString(k);
										k3 = Integer.toHexString(l);
										k4 = Integer.toHexString(m);
										k5 = Integer.toHexString(n);
										k6 = Integer.toHexString(o);
										k7 = Integer.toHexString(p);
										
										String key = k0+k1+k2+k3+k4+k5+k6+k7+"2734a516";
										
										SecretKeySpec rc4Key = new SecretKeySpec(key.getBytes("ASCII"), "RC4");
										Cipher rc4Decrypt = Cipher.getInstance("RC4");
										rc4Decrypt.init(Cipher.DECRYPT_MODE, rc4Key);
										String result = new String(rc4Decrypt.update(cipherText), "ASCII");

										if (result.matches("[a-zA-Z0-9 .?,!()@\"'%-+]+")) {
											System.out.println(result);
											pw.println(key);
											pw.println(result);
											pw.close();
											return;
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

}
