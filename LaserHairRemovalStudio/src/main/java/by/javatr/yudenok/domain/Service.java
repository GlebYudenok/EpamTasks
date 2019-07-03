package by.javatr.yudenok.domain;

import java.math.BigDecimal;

public class Service extends Entity{

    private String serviceName;
    private BigDecimal price;

    public Service(Integer id) {
        super(id);
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Service service = (Service) o;

        if (serviceName != null ? !serviceName.equals(service.serviceName) : service.serviceName != null) return false;
        return price != null ? price.equals(service.price) : service.price == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
