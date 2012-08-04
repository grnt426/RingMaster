package RingMaster;

/**
 * Author:      Grant Kurtz
 */
public class Main {

	private static final String CLIENT = "client";
	private static final String SERVER = "server";

	public static void main(String[] args){
		String name = args[0];
		Model model = new Model(name);
		Controller c = null;
		if(args.length == 1){
			c = new Controller(name, model);
		}
		else if(args.length == 2){
			c = new Controller(name, model, args[1]);
		}
		else{
			printBadArgs();
			System.exit(1);
		}

		Console cli = new Console(c);
		System.out.println("RingMaster!");
		cli.processCommands();
	}

	private static void printBadArgs() {
		System.err.println("Usage: java -jar ringmaster.jar name " +
				"[server IP]");
	}
}
