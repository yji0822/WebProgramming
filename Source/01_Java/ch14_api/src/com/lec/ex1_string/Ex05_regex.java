package com.lec.ex1_string;

public class Ex05_regex {
	public static void main(String[] args) {
		String str = "010-9999-9999 yisy0703@naver.com (02)565-8888 ¹İ°©½À´Ï´Ù. Hello 951212-2521251  010-7777-8888  abc@hong.co.kr";
//		System.out.println("replace => " + str.replace("0", "È«")); // Æ¯Á¤¹®ÀÚ¿­¸¸ º¯°æ °¡´É - 0¸¸ È«À¸·Î
//		System.out.println(str.replace("010-8888-8888", newChar)); - ºÒ°¡
		// Á¤±ÔÇ¥Çö½Ä 
		// Æ¯Á¤ÇÑ ±ÔÄ¢À» °®°í ÀÖ´Â..!
		/* Á¤±ÔÇ¥Çö½Ä(regex)
		 * 1. Âü°í : https://goo.gl/HLntbd
		 * 2. °£·« ¹®¹ı 
		 * 		\d - (¼ıÀÚ¿Í ¸ÅÄ¡, [0-9] ¿Í µ¿ÀÏ) \D - ¼ıÀÚ°¡ ¾Æ´Ñ °Í
		 * 		\s - (whitespacen : space, ÅÇ, ¿£ÅÍ)
		 * 		\w - (¿µ¹®ÀÚ³ª ¼ıÀÚ, [a-zA-Z0-9]¿Í µ¿ÀÏ) \W - ¿µ¹®ÀÚ³ª ¼ıÀÚ°¡ ¾Æ´Ñ¹®ÀÚ
		 * 		. - (¹®ÀÚÇÏ³ª)
		 * 		+ - 1¹ø ÀÌ»ó ¹İº¹
		 * 		* - 0¹ø ÀÌ»ó ¹İº¹
		 * 		? - 0~1¹ø ¹İº¹
		 * 		{2,3} {2,4} - 2~3È¸ ¹İº¹, 2~4È¸ ¹İº¹
		 * 3. Á¤±ÔÇ¥Çö½Ä ¿¬½ÀÀå - ±¸±Û¸µ
		 * https://www.regexpal.com/
		 * regexr.com
		 * ex) ÀüÈ­¹øÈ£ : [(]?[0-9]{2,3}\D[0-9]{3,4}-[0-9]{4}
		 * 	       ÀÌ¸ŞÀÏ : \w+@\w+(.\w+){1,2}
		 * 4. Æ¯Á¤ Á¤±ÔÇ¥Çö½ÄÀÇ ¹®ÀÚ¿­ º¯°æ : (ÀüÈ­¹øÈ£¸¦ ½Ï ´Ù º¯°æÇÏ°í ½ÍÀº °æ¿ì) replaceAll("Á¤±ÔÇ¥Çö½Ä", "´ëÃ¼¹®ÀÚ¿­") ³»°¡ ¹Ù²Ù°í ½ÍÀº ¹®ÀÚ¿­(´ëÃ¼¹®ÀÚ)
		 */
		
//		System.out.println(str.replaceAll("[0-9]", "X"));
//		System.out.println(str.replaceAll("\\d", "X")); // \n \tÃ³·³ Æ¯º°ÇÑ ±â´ÉÀÌ ÀÖ´ÂÁÙ ¾Ë°í ÀÎ½ÄÇØ¼­ ¿À·ù°¡ ¶ß±â ¶§¹®¿¡ \¸¦ ¹®ÀÚ·Î ¾²°í ½ÍÀ¸¸é ÇÑ¹ø ´õ Àû¾îÁØ´Ù
//		System.out.println(str.replaceAll("\\D", "** ÀüÈ­¹øÈ£ Áö¿ò **"));
		// * ÀüÈ­¹øÈ£ Áö¿ò
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}", "**ÀüÈ­¹øÈ£ Áö¿ò **"));
		System.out.println();
		// ÀÌ¸ŞÀÏ Áö¿ò
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "==ÀÌ¸ŞÀÏ»èÁ¦=="));
		System.out.println();
		// ¾ËÆÄºª ´ë½Å *·Î ´ëÃ¼
		System.out.println("¾ËÆÄºª ´ë½Å *·Î ´ëÃ¼ : " + str.replaceAll("[a-zA-Z]", "*"));
		// ÇÑ±Û ½Ï ´Ù ¾ø¾Ö±â
		System.out.println("ÇÑ±Û»èÁ¦ : " + str.replaceAll("[°¡-ÆR¤¡-¤¾]", "#"));
		// ÁÖ¹Î¹øÈ£ µŞÀÚ¸®¸¦ *·Î ´ëÃ¼
		System.out.println("ÁÖ¹Î¹øÈ£ µŞÀÚ¸® »èÁ¦ : " + str.replaceAll("[0-9]{7}", "*******")); // 7¹ø¹İº¹ÇÑ´Ù. - ÁÖ¹Î¹øÈ£
		
		
	}
}
