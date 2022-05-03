package com.lec.ex6_wrapper;

import java.util.Scanner;

// »ç¿ëÀÚ·ÎºÎÅÍ Á¤¼ö ¹®ÀÚ¿­("100")À» ÀÔ·Â ¹Ş¾Æ Á¤¼ö·Î ¼öÁ¤ÇØ¼­ Ãâ·ÂÇÏ´Â ÇÁ·Î±×·¥
// idÀÔ·ÂÇÒ¶§ spaceÀÔ·ÂµÈ °ÍÀ» Áö¿öÁÖ´Â °Í
public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Á¤¼ö(int num)¸¦ ÀÔ·ÂÇÏ¼¼¿ä : ");
		int num = sc.nextInt();
		System.out.println("ÀÔ·ÂÇÏ½Å Á¤¼ö´Â " + num);

		System.out.print("Á¤¼ö(String numStr)¸¦ ÀÔ·ÂÇÏ¼¼¿ä : ");
		sc.nextLine(); // ÃÊ±âÈ­
		String numStr = sc.nextLine(); // ´Ù¸¥ ¹®ÀÚ°¡ µé¾î¿Ã ¼öµµ ÀÖ´Ù.
		numStr = numStr.trim(); // *** ¸¹ÀÌ »ç¿ë *** ÁÂ¿ì ½ºÆäÀÌ½º°¡ Á¦°ÅµÈ´Ù.(numStr¿¡ ÀÖ´Â °ø¹é Á¦°Å)
//		numStr = numStr.replace("Á¡", ""); - Á¡ÀÌ¶õ ´Ü¾î ÇÏ³ª¸¸ Áö¿ì°Ô µÇ´Â ´ÜÁ¡
		numStr = numStr.replaceAll("[a-zA-Z°¡-ÆR]", ""); // ¹®ÀÚ Á¦°Å
		int num1 = Integer.parseInt(numStr); 
		// ½ºÆäÀÌ½º³ª ºóstring°ªÀ» ³ÖÀ¸¸é ¿À·ù¹ß»ı - StringÀ» Integer·Î ¹Ù²ãÁÖ´Â ÇÔ¼ö / ¹®ÀÚ¿­¸¸ ÀÔ·Â¹Ş¾ÒÀ» °æ¿ì ¿À·ù ¹ß»ı
		System.out.println("ÀÔ·ÂÇÏ½Å ¹®ÀÚ¿­Àº " + numStr);
		
	}

}
