/**
* Interface to the Geospatial Widget.
*
*
**/
public interface GeospatialWidgetInterface {

    /**
    * Access points for getting a record of a geographic object with GPS
    * Story G1.1 , G1.3

    **/
    public int startRecordLocation();
	
    public void pauseRecordLocation(int routeId);
	
    public void resumeRecordLocation(int routeId); 
	
    public JSONArray stopRecordLocation(int routeId);
	
    	
    /**
    * Access points for splitting polygons 
    * 
    *
    **/
	
    public void startSplitPolygon(int polygonId); 
	
    public JSONObject setFirstSplittingPoint(int polygonId);
	
    public JSONObject setSecondSplittingPoint(int polygonId);
	
    public JSONArray stopSplitPolygon(int polygonId);


    /**
    * Access point for getting Point information by touching the map
    *
    **/
    public JSONObject getPointLocation();

    /**
    * Access point for creating Circle
    * Story G3.9
    *
    **/
    public JSONArray getCircleLocation(JSONObject point, int radius); // By giving a point

    public JSONArray getCircleLocation(int radius);                   // with GPS 
}
