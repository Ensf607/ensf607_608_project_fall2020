package server.model;

/**
 * The type Purchase.
 */
public class Purchase {
    private int clientID;
    private int toolID;
    private String date;

    /**
     * Sets client id.
     *
     * @param clientID the client id
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /**
     * Sets tool id.
     *
     * @param toolID the tool id
     */
    public void setToolID(int toolID) {
        this.toolID = toolID;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * Gets tool id.
     *
     * @return the tool id
     */
    public int getToolID() {
        return toolID;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Instantiates a new Purchase.
     *
     * @param clientID the client id
     * @param toolID   the tool id
     * @param date     the date
     */
    public Purchase(int clientID, int toolID, String date) {
        this.clientID = clientID;
        this.toolID = toolID;
        this.date = date;
    }

    //string item, quatinty, date, ..etc

}
