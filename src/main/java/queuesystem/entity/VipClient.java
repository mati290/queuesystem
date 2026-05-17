package queuesystem.entity;

public class VipClient extends Client{
    @Override
    public String getClientType() {
        return "VIP";
    }
}

