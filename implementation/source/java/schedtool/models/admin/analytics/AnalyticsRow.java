package models.admin.analytics;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AnalyticsRow
{
    private SimpleStringProperty name;
    private SimpleIntegerProperty quality;
    
    public AnalyticsRow(String name, Integer quality)
    {
        this.name = new SimpleStringProperty(name);
        this.quality = new SimpleIntegerProperty(quality);
    }

    public String getName()
    {
        return name.get();
    }

    public Integer getQuality()
    {
        return quality.get();
    }
}