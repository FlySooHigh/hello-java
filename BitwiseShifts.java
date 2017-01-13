
public class BitwiseShifts 
{
	public static void main(String[] args) 
	{
		System.out.println( (byte) (0b0001_1111));			// 31
		System.out.println( (byte) (0b0001_1111 << 1)); 	// 62
		System.out.println( (byte) (0b0001_1111 << 2)); 	// 124
		System.out.println( (byte) (0b0111_1100 << 3));		// -32
		
		System.out.println( (byte) (0b0000_0000));		// 0
		System.out.println( (byte) (0b1111_1111));		//-1
		
		System.out.println( (byte) (0b0001_1111));			// 31
		System.out.println( (byte) (0b1110_0000));			// -32
		System.out.println( (byte) (0b1110_0000 << 1));		// -64
		System.out.println( (byte) (0b1110_0000 << 2));		// -128
		System.out.println( (byte) (0b1110_0000 << 3));		// 0
		
		System.out.println(0b010_0000);			// 32
		System.out.println(0b010_0000 >> 2);	// 8
		
		System.out.println(0b010_0011);			// 35
		System.out.println(0b010_0011 >> 2);	// 8
		
		int i = -4;
		System.out.println(i >> 1);		// -2
		System.out.println(i >> 2);		// -1
		System.out.println(i >> 3);		// -1 !! because of sign extension, the leftmost bit is preserved
		System.out.println(i >> 4);		// -1 
		
		System.out.println(i >>> 1);		// 2147483646, unsigned right shift
		
		int a = -1;						// 11111111 11111111 11111111 11111111
		System.out.println(a >>> 24);	// 00000000 00000000 00000000 11111111 = 255 
		
		
		System.out.println( (byte) (0b1111_1111));			// -1
		System.out.println( (byte) (0b1111_1111 >> 1));		// 127, because byte is promoted to int and then by casting we truncate left side,
															// which contains minus sign
		
		System.out.println(0xFFF_FFFF);				// 268435455
		System.out.println(0xFFF_FFFF << 1);		// 536870910  = 1FFF_FFFE
		System.out.println(0xFFF_FFFF << 2);		// 1073741820 = 3FFF_FFFC
		System.out.println(0xFFF_FFFF << 3);		// 2147483640 = 7FFF_FFF8
		System.out.println(0xFFF_FFFF << 4);		// -16		  = FFFF_FFFF_FFFF_FFF0
		
		String hex = "FFFFFFFF";
		int parsedResult = (int) Long.parseLong(hex, 16);
		System.out.println(parsedResult);
		
		int value = -16;
		String hexa = Long.toHexString(value);
		System.out.println(hexa);
		
		System.out.println(0xFFFF);				// 65535
	}
}
