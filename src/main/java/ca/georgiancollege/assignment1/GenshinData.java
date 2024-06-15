package ca.georgiancollege.assignment1;

public class GenshinData {
    //version, character, revenue, start date, end date, banner days
    private double version;
    private String character, startDate, endDate;
    private int revenue, bannerDays;

    public GenshinData(double version, String character, int revenue, String startDate, String endDate, int bannerDays) {
        setVersion(version);
        setCharacter(character);
        setRevenue(revenue);
        setStartDate(startDate);
        setEndDate(endDate);
        setBannerDays(bannerDays);
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getBannerDays() {
        return bannerDays;
    }

    public void setBannerDays(int bannerDays) {
        this.bannerDays = bannerDays;
    }
}
