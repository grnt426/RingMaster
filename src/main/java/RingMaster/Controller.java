package RingMaster;

/**
 * Author:      Grant Kurtz
 */
public class Controller {

	public Controller(boolean server, Model model) {
		if(server){
			model.startServer();
		}
		else{
			model.startClient();
		}
	}
}
