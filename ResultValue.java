
public enum ResultValue
{
  FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH, TENTH, OTHER;

  /*
   * Rewrite this method to use switch instead of if where it makes sense
   */

  public static ResultValue getResult(String type, String number)
  {
	  if ("20".equals(type))
	  {
		  switch (number)
		  {
		  	case "30": return ResultValue.FIFTH; 
		  	case "40": return ResultValue.SEVENTH;
		  	case "41": return ResultValue.FIRST;
		  }
	  }
	  else if ("30".equals(type))
	  {
		  switch (number)
		  {
		  	case "20": return ResultValue.THIRD; 
		  	case "30": return ResultValue.NINTH;
		  	case "32": return ResultValue.EIGHTH;
		  	case "33": return ResultValue.SIXTH;
		  	case "34": return ResultValue.TENTH;
		  	case "62": return ResultValue.SECOND;
		  }
	  }
	  else if ("40".equals(type) && ("00".equals(number) || "0".equals(number))) {return ResultValue.FOURTH;}
	  return ResultValue.OTHER;
  }
}
