package server.model;

public class Purchase {
    private int clientID;
    private int toolID;
    private String date;

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public void setToolID(int toolID) {
        this.toolID = toolID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getClientID() {
        return clientID;
    }

    public int getToolID() {
        return toolID;
    }

    public String getDate() {
        return date;
    }

    public Purchase(int clientID, int toolID, String date) {
        this.clientID = clientID;
        this.toolID = toolID;
        this.date = date;
    }

    //string item, quatinty, date, ..etc

}
