package entity;


import enums.EditionType;

public class Edition {
    private int id;
    private String editionName;
    private EditionType editionType;
    private double subscriptionCost;
    private int circulation;

    public Edition(int id, String editionName, EditionType editionType, double subscriptionCost, int circulation) {
        this.id = id;
        this.editionName = editionName;
        this.editionType = editionType;
        this.subscriptionCost = subscriptionCost;
        this.circulation = circulation;
    }

    public Edition(String editionName) {
        this.editionName = editionName;
    }

    public String getEditionName() {
        return editionName;
    }

    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public double getSubscriptionCost() {
        return subscriptionCost;
    }

    public void setSubscriptionCost(double subscriptionCost) {
        this.subscriptionCost = subscriptionCost;
    }

    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "id=" + id +
                ", editionName='" + editionName + '\'' +
                ", editionType=" + editionType +
                ", subscriptionCost=" + subscriptionCost +
                ", circulation=" + circulation +
                '}';
    }
}
