class OneEdit
{
	public static boolean isOneEdit(String a , String b)
	{
		if( (a==null && b != null) || (a != null && b == null) || Math.abs(a.length() - b.length()) > 1)
			return false;
		String shorter = a.length() < b.length() ? a : b;
		int shortLen = shorter.length();		
		String longer = b.length() > a.length() ? b : a;
		int longLen = longer.length();
		int shortPointer = 0, longPointer = 0;
		boolean foundMismatch = false;

		while(shortPointer  < shortLen && longPointer < longLen)
		{
			if(shorter.charAt(shortPointer) != longer.charAt(longPointer))
			{
				if(foundMismatch)
					return false;
				foundMismatch = true;
				if(shortLen != longLen)
					longPointer++;
				else
				{
					shortPointer++;
					longPointer++;
				}
			}
			else
			{
				shortPointer++;
				longPointer++;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		boolean ans = isOneEdit(args[0], args[1]);
		System.out.println(ans);
	}
}