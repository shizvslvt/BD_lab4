package main;

import lombok.Data;

import java.util.Date;

@Data
public class Estate {
    private int id;
    private int sellerId;
    private String title;
    private int cost;
    private int type;
    private int locality;
    private int city;
    private int area;
    private int bedrooms;
    private int floors;
    private Date DateCreated;
    private int deal;
    private int viewed;
    private int archived;


    @Override
    public String toString() {
        return "ID: " + id + "   Seller ID: " + sellerId + "   Title: " + title + "   Cost: " + cost +
                "   Type: " + type + "   Locality: " + locality + "   City: " + city + "   Area: " + area + "   Bedrooms: " + bedrooms + "   Floors: " + floors +
                "\nDate Created: " + DateCreated + "   Deal: " + deal + "   Viewed: " + viewed + "   Archived: " + archived;
    }
}


