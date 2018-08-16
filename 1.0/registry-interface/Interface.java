/**
* Interface to/from the Common Geo-Registry.
*
*
**/
public interface RegistryInterface {

    /**
    * Access points for getting a single location object.
    *
    **/
    public JSONObject getLocationById(String id, String geomType);
    
    
    /**
    * Access points for getting a collection of location objects from a specific position in the location hierarchy.
    *
    **/
    public JSONArray getLocationsByHierarchyPosition(String hierarchyPositionName, String geomType);
    
    
    /**
    * Access points for getting direct child location objects of a location.
    *
    **/
    public JSONArray getDirectChildLocationsById(String id, String geomType);
    
    public JSONArray getDirectChildLocationsById(String id, String hierarchyPositionName, String geomType);
    
    
    /**
    * Access points for getting direct parent location objects of a location.
    *
    **/
    public JSONArray getDirectParentLocationsById(String id, String geomType);
    
    public JSONArray getDirectParentLocationsById(String id, String hierarchyPositionName, String geomType);
    
    
    /**
    * Access points for setting location objects.
    *
    **/
    public Boolean setLocation(JSONObject location);
}
