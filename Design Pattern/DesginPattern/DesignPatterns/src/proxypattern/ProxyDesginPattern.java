package proxypattern;

interface Greeter{
	
	void meet(String name);
	void leave(String name);
}

class EnglishGreeter implements Greeter{
	
	public void meet(String name) {
		System.out.printf("Hello %s%n", name);
	}
	
	public void leave(String name) {
		System.out.printf("Bye %s%n", name);
	}
}

class FrenchGreeter implements Greeter{
	
	public void meet(String name) {
		System.out.printf("French Hello %s%n", name);
	}
	
	public void leave(String name) {
		System.out.printf("French Bye %s%n", name);
	}
}

class Proxy{
	
	Greeter greeter;	//Static Proxy
	
	public Proxy(Greeter eg) {
		greeter = eg;
	}
	
	public void meet(String name) {
		System.out.println("Before meet....");
		greeter.meet(name);
		System.out.println("After meet....");
	}
	
	public void leave(String name) {
		System.out.println("Before leave....");
		greeter.leave(name);
		System.out.println("After leave....");
	}
}

public class ProxyDesginPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Proxy eproxy = new Proxy(new EnglishGreeter());
		eproxy.meet("Jack");
		eproxy.leave("Jack");
		
		Proxy fproxy = new Proxy(new FrenchGreeter());
		fproxy.meet("Jack");
		fproxy.leave("Jack");
	}

}
