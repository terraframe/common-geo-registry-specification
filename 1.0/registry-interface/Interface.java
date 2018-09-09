/**
* Interface to/from the Common Geo-Registry.
*
*
**/
public interface RegistryInterface {

    /**
    * Returns a GeoObject with the given uid.
    *
    * @pre
    * @post
    *
    * @param uid The UID of the GeoObject.
    *
    * @returns a GeoObject in GeoJSON format with the given uid.
    * @throws
    **/
    public GeoJSONObject getGeoObject(String uid);  
    
    /**
    * Create a new GeoObject in the Common Geo-Registry
    *
    * @pre UID of the GeoObject needs to have been issued by the Common Geo-Registry
    * @post geoObject is persisted in the Common Geo-Registry
    *
    * @param geoObject in GeoJSON format of the newly created.
    *
    * @returns 
    * @throws //TODO
    **/
    public void createGeoObject(GeoJSON geoObject);  
    
    /**
    * Update a new GeoObject in the Common Geo-Registry
    *
    * @pre 
    * @post 
    *
    * @param geoObject in GeoJSON format to be updated.
    *
    * @returns 
    * @throws //TODO
    **/
    public void updateGeoObject(GeoJSON geoObject);  
    
    /**
    * Get children of the given GeoObject
    *
    * @pre 
    * @post 
    *
    * @param parentUid UID of the parent object for which the call fetches children.
    * @param childrentTypes An array of GeoObjectType names of the types of children GeoObjects to fetch.
    * @param recursive TRUE if recursive children of the given parent with the given types should be returned, FALSE if only single level children should be returned.  
    * 
    * @returns
    * @throws
    **/
    public TreeNode getChildGeoObjects(String parentUid, String[] childrenTypes, Boolean recursive);
     
    /**
    * Get parents of the given GeoObject
    *
    * @pre 
    * @post 
    *
    * @param childUid UID of the child object for which the call fetches parents.
    * @param parentTypes An array of GeoObjectType names of the types of parent GeoObjects to fetch.
    * @param recursive TRUE if recursive parents of the given parent with the given types should be returned, FALSE if only single level parents should be returned.  
    * 
    * @returns
    * @throws
    **/   
    public TreeNode getParentGeoObjects(String childUid, String[] parentTypes, Boolean recursive);
    
    
    /**
    * Access points for getting UIDs. The Common Geo-Registry will only accept newly created GeoObjects with a UID that was issued from the Common GeoRegistry.
    *
    * @precondistions
    * @postconditions
    * @returns
    * @throws
    **/
    String[] getUIDs(Integer : numberOfUIDs);
    
    
    
    /**
    * Access points for getting UIDs. Commonly used to retrieve an acceptable ID which could be used to persist a new GeoObject.
    *
    * @precondistions
    * @postconditions
    * @returns
    * @throws
    **/
    GeoObjectType[] getGeoObjectTypes(String[] types);
    
    
    
    
    /**
    * Access points for setting location objects. 
    *
    * @precondistions
    * @postconditions
    * @returns
    * @throws
    **/
    public Boolean setLocation(JSONObject location);
}
