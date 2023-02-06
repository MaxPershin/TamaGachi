package you.count.youcountdesktopalpha;

import you.count.youcountdesktopalpha.interfaces.Environment;

public class VillageHouse implements Environment {

    private String name, description;
    private int temperature, cost;

    public VillageHouse() {

        name = "Домик в деревне";
        description = "Длинное описание домика";
        temperature = 25;
        cost = 2500;

    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
