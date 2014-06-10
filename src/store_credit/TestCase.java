package store_credit;

public class TestCase{

	public int caseNumber;
	public int creditAmount;
	public int[] items;
	
	public TestCase(int caseNumber, int creditAmount, String items, int itemCount) throws Exception{
		this.caseNumber = caseNumber;
		this.creditAmount = creditAmount;
		String[] rawItems = items.split(" ");
		if(itemCount != rawItems.length){
			throw new Exception("Got: "+rawItems.length+" expected: "+itemCount);
		}
		this.items = new int[itemCount];
		for(int i = 0; i < rawItems.length; ++i){
			this.items[i] = Integer.parseInt(rawItems[i]);
		}
	}

}
