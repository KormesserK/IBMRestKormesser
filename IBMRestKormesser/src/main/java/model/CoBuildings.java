package model;

public class CoBuildings {
    private String department;
    private String source_type;
    private String emissions_mtco2e;

    public CoBuildings(){

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }

    public String getEmissions_mtco2e() {
        return emissions_mtco2e;
    }

    public void setEmissions_mtco2e(String emissions_mtco2e) {
        this.emissions_mtco2e = emissions_mtco2e;
    }
}
