package RingMaster;

/**
 * Author:      Grant Kurtz
 */
public class Controller {

	public Controller(String name, Model model){
		model.startServer();
	}

	public Controller(String name, Model model, String ip) {
		model.startClient(ip);
	}
}
