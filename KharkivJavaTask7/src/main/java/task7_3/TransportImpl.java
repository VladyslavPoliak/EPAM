package task7_3;

public class TransportImpl implements Transport{

    private int id;
    private int price;
    private String producer;
    private int enginePower;
    private int yearOfRelease;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getProducer() {
        return producer;
    }

    @Override
    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public int getEnginePower() {
        return enginePower;
    }

    @Override
    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public int getYearOfRelease() {
        return yearOfRelease;
    }

    @Override
    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
}
