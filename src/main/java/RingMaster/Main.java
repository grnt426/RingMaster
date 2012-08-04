package RingMaster;

/**
 * Author:      Grant Kurtz
 */
public class Main {

	private static final String CLIENT = "client";
	private static final String SERVER = "server";

	public static void main(String[] args){
		if(args.length != 2){
			printBadArgs();
			System.exit(1);
		}

		String name = args[1];
		Controller c = null;
		if(args[0].equalsIgnoreCase(CLIENT)){
			 c = new Controller(false, new Model());
		}
		else if(args[0].equalsIgnoreCase(SERVER)){
			c = new Controller(true, new Model());
		}
		else{
			printBadArgs();
			System.exit(1);
		}
		Console cli = new Console(c);
		System.out.println("RingMaster!");
	}

	private static void printBadArgs() {
		System.err.println("Usage: java -jar ringmaster.jar client/server " +
				"name");
	}
}
