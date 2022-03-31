package com.lec.ex1_string;

public class Ex02_stringAPImethod {

	public static void main(String[] args) {
		
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "    ja    va     ";
		
		System.out.println("1. " + str1.concat(str2)); 
		// 1. abcXabcABCXabc - String µÎ°³¸¦ ´õÇÏ´Â ¸Ş¼Òµå (ÄÁÄ¹ÇÑ´Ù)
		System.out.println("2. " + str1.substring(3)); // 2. Xabc - 3¹øÂ° ÀÎµ¦½ººÎÅÍ ³¡±îÁö Ãâ·Â
		System.out.println("3. " + str1.substring(3, 5)); // 3. Xa - 3¹øÂ°ºÎÅÍ 5¹øÂ° ¾Õ±îÁö
		
		System.out.println("4. " + str1.length()); // 4. 7 - ±ÛÀÚ±æÀÌ
		
		System.out.println("5. " + str1.toUpperCase()); // 5. ABCXABC - ´ë¹®ÀÚ·Î
		System.out.println("6. " + str1.toLowerCase()); // 6. abcxabc - ¼Ò¹®ÀÚ
		System.out.println("7. " + str1.charAt(3)); // 7. X - 3¹øÂ° ¹®ÀÚ ¹İÈ¯
		
		System.out.println("8. " + str1.indexOf('b')); 
		// 8. 1 - Ã¹¹øÂ° b¹®ÀÚ°¡ ³ª¿À´Â ÀÎµ¦½º À§Ä¡(½ÃÀÛ ¼ıÀÚ 0)
		System.out.println("9. " + str1.indexOf('b', 3)); 
		// 9. 5 - 3¹øÂ°ºÎÅÍ °Ë»öÇØ¼­ ³ª¿À´Â Ã¹¹øÂ° 'b'ÀÇ ÀÎµ¦½º À§Ä¡
		System.out.println("10. " + str1.indexOf("abc"));
		// 10. 0 - Ã¹¹øÂ° abc°¡ ³ª¿À´Â À§Ä¡
		System.out.println("11. " + str1.indexOf("abc",3));
		// 11. 4 - 3¹øÂ°ºÎÅÍ °Ë»öÇØ¼­ ³ª¿À´Â "abc"À§Ä¡
		// 12. -1 - Ã£´Â ±ÛÀÚ°¡ ¾øÀ¸¸é -1À» ¹İÈ¯ÇÑ´Ù.
		System.out.println("12. " + str1.indexOf('z'));
		System.out.println("13. " + str1.lastIndexOf('b'));
		// 13. 5 - ¸¶Áö¸· bÀÇ À§Ä¡ ÀüÈ­¹øÈ£ ¾µ ¶§ ¸¹ÀÌ »ç¿ë
		System.out.println("14. " + str1.lastIndexOf('b', 3));
		// 14. 1 - 3¹øÂ°ºÎÅÍ ¸Ç ¸¶Áö¸· b
		
		str1 = "abcXabc";
		str2 = new String("ABCXabc");
		str3 = "    ja    va     ";
		
		System.out.println("15. " + str1.equals(str2));
		// 15. false str1°ú str2°¡ °°Àº ¹®ÀÚ¿­ÀÎÁö È®ÀÎ
		System.out.println("16. " + str1.equalsIgnoreCase(str2)); // 16. true - ´ë¼Ò¹®ÀÚ±¸ºĞ¾øÀÌ ºñ±³  **
		System.out.println("17. " + str3.trim()); // 17. ja    va - ¾Õ µÚ °ø¹éÁ¦°Å (Áß°£ °ø¹éÁ¦°ÅÇÏ´Â°Ç ¾ÈµÊ)
		System.out.println("18. " + str1.replace('a', '9')); // 18. 9bcX9bc - ¸ğµç 'a'¸¦ '9'·Î ¼öÁ¤ÇÑ´Ù
		System.out.println("19. " + str1.replace("abc", "#")); //19. #X# - ¿©·¯¹®ÀÚ¸¦ ÇÑ²¨¹ø¿¡ º¯°æµµ °¡´É
		System.out.println("20. " + str3.replace(" " , "")); // 20, java - °ø¹é ¸ğµÎ Á¦°Å!
		System.out.println("21-1. " + str1.replaceAll("abc", "Z")); // "abc"À» "Z"·Î
		System.out.println("21-2. " + str1.replace("abc", "Z")); // "abc"À» "Z"·Î
		
		// Á¤±Ô Ç¥Çö½Ä
		String str = "¾È³çHello"; //ÇÑ±ÛÀÌ³ª ¿µ¾î µÑ Áß ÇÏ³ª¸¦ ¸ğµÎ Áö¿ì°í ½ÍÀ»¶§
		// ¿µ¹®ÀÚ¸¦ ¸ğµÎ *·Î ¹Ù²Ù°Å³ª...
		System.out.println(str.replaceAll("[a-zA-Z]", "")); 
		// ¾ËÆÄºªÀ» ""·Î ¼öÁ¤ÇÏ´Â.. ¾ËÆÄºª ¼Ò¹®ÀÚ¿Í ´ë¹®ÀÚ... ½ÃÀÛ°ú ³¡À» Àû¾îÁØ °Í.
		System.out.println(str.replaceAll("[°¡-ÆR]", ""));
		// ÇÑ±ÛÀº ½ÃÀÛÀÌ °¡°í ¸¶Áö¸·ÀÌ ÆRÀÓ.
		// ¹®ÀÚ¿­ ¸Ş¼Òµå´Â ¹®ÀÚ¿­À» ¼öÁ¤ÇÏÁö ¾ÊÀ½.
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);
		// Ãâ·ÂµÈ °ÍÀ» º¸¸é Ã³À½ ³Ö¾îµÎ¾ú´ø ¹®ÀÚ¿­µéÀÌ ¹Ù²ï °ÍÀº ¾Æ´Ï´Ù. ±×³É ¼öÁ¤ÇØ¼­ Ãâ·ÂÇÑ °Í.
	} 
}
