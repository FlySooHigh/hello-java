
public enum ResultValue
{
  FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, NINTH, TENTH, OTHER;

  /*
   * Rewrite this method to use switch instead of if where it makes sense
   */

  public static ResultValue getResult(String type, String number)
  {
    if ("20".equals(type) && "41".equals(number))
      return ResultValue.FIRST;
    if ("30".equals(type) && "62".equals(number))
      return ResultValue.SECOND;
    if ("30".equals(type) && "20".equals(number))
      return ResultValue.THIRD;
    if ("40".equals(type) && ("00".equals(number) || "0".equals(number)))
      return ResultValue.FOURTH;
    if ("20".equals(type) && "30".equals(number))
      return ResultValue.FIFTH;
    if ("30".equals(type) && "33".equals(number))
      return ResultValue.SIXTH;
    if ("20".equals(type) && "40".equals(number))
      return ResultValue.SEVENTH;
    if ("30".equals(type) && "32".equals(number))
      return ResultValue.EIGHTH;
    if ("30".equals(type) && "30".equals(number))
      return ResultValue.NINTH;
    if ("30".equals(type) && "34".equals(number))
      return ResultValue.TENTH;
    return ResultValue.OTHER;
  }
  
  public static ResultValue getResult1(String type, String number)
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
	  else {return ResultValue.OTHER;}
  }
}
