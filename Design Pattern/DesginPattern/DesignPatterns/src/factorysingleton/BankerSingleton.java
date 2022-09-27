package factorysingleton;

public class BankerSingleton {
	
	//Step 3 - make constructor private
	private BankerSingleton() {}
	
	
	//Step 1 - Create a static object of your type
	private static BankerSingleton singleton = null;
	
	//Step 2 = Create a static method which creates instance on your class
	private static BankerSingleton create() {
		if(singleton == null) {
			singleton = new BankerSingleton();
		}
		return singleton;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankerSingleton bs1 = BankerSingleton.create();
		BankerSingleton bs2 = BankerSingleton.create();
		System.out.println(bs1);
		System.out.println(bs2);
	}

}
