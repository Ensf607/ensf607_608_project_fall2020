package client.controller;
/**
 * Interface used by GUI controllers to send requests
 * @author zchem
 *
 */
public interface Observer {

	public String request(String json);
}
