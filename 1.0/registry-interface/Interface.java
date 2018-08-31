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
    public JSONObject getGeoObject(String id);  
    
    /**
    * Access points for getting child location objects of a location.
    *
    **/
    public JSONArray getChildGeoObjects(String id);
    
    public TreeNode getChildGeoObjects(String parentUid, String[] childrenTypes, Boolean recursive);
     
    /**
    * Access points for getting parent location objects of a location.
    *
    **/
    public JSONArray getParentGeoObjects(String id);
    
    public TreeNode getParentGeoObjects(String parentUid, String[] childrenTypes, Boolean recursive);
    
    
    /**
    * Access points for getting UIDs. 
    *
    **/
    String[] getUIDs(Integer : numberOfUIDs);
    
    
    
    
    /**
    * Access points for setting location objects.
    *
    **/
    public Boolean setLocation(JSONObject location);
}
