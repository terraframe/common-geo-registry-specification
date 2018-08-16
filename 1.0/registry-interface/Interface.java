/**
* Interface to/from the Common Geo-Registry.
*
*
**/
public interface RegistryInterface {

    /**
    * Access points for getting location objects.
    *
    * Return type: JSON Object
    **/
    public JSONObject getLocationById(String id, String geomType);
    
    public JSONObject getLocationByName(String name, String geomType);
    
    
    /**
    * Access points for getting child location objects of a parent location.
    *
    * Return type: JSON Object
    **/
    public JSONArray getChildLocationsById(String parentId, String geomType);
    
    public JSONArray getChildLocationsByName(String parentName, String geomType);
    
    
    /**
    * Access points for setting location objects.
    *
    * Return type: Boolean
    **/
    public Boolean setLocation(JSONObject location);
}
