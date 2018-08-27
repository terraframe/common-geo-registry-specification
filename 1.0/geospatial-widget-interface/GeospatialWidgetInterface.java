/**
* Interface to the Geospatial Widget.
*
*
**/
public interface GeospatialWidgetInterface {

    /**
    * Access point for getting coordinates of a the current position
    *
    **/
    public JSONObject getLocation();

    public JSONObject getDirection();
    
    
    /**
    * Access points for getting a record of a geographic object with GPS
    *
    **/
    public int startRecordLocation();
	
    public void pauseRecordLocation(int recordId);
	
    public void resumeRecordLocation(int recordId); 
	
    public JSONArray stopRecordLocation(int recordId);
	
    /**
    * Access points for getting a record of a geographic object without GPS
    * 
    *
    **/
    public int startDrawingLocation();
	
    public JSONObject addDrawingPoint(int drawingId); // Return Point information
	
    public void deleteDrawingPoint(int drawingId, int drawingPointId);
	
    public JSONArray stopDrawingLocation(int drawingId);
	
    /**
    * Access points for splitting polygons 
    * 
    *
    **/
	
    public void startSplitPolygon(int polygonId); 
	
    public JSONObject setFirstSplittingPoint(int polygonId);
	
    public JSONObject setSecondSplittingPoint(int polygonId);
	
    public JSONArray stopSplitPolygon(int polygonId);
}
