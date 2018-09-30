
# Single GeoObject
GeoObjects can be queried to & from the common geo-registry.

| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /geoobject  |  GET  |  <ul><li>uid=:uid</li></ul>  |  Get a GeoObject by id.  |
|  /geoobject  |  POST  | <ul><li>geoobject=:geoObject</li></ul>  |  Create a GeoObject.  |
|  /geoobject  |  PUT  | <ul><li>geoObject=:geoObject</li></ul>  |  Update a GeoObject.  |

### Example
```
www.domain.com/getGeoObject?id=99999999
```
```
www.domain.com/createGeoObject?geoObject={}
```
```
www.domain.com/updateGeoObject?geoObject={}
```

# GeoObjects By Relationship
GeoObject can be queried based on relationships to other GeoObjects.

| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /childgeoobjects  |  GET  |  <ul><li>parentUid=:parentUid</li> <li>childrenTypes=:string[]</li> <li>recursive=:boolean </li></ul>  |  Get all direct child GeoObjects of a specific GeoObject.  |
|  /parentgeoobjects  |  GET  |  <ul><li>childUid=:childUid</li> <li>parentTypes=:string[]</li> <li>recursive=:boolean </li></ul>  |  Get all direct parent GeoObjects of a specific GeoObject.  |

### Example
```
www.domain.com/childgeoobjects?parentUid=999999&childrenTypes=type1,type2,type3&recursive=false
```
```
www.domain.com/parentgeoobject?childUid=999999&parentTypes=type1,type2,type3&recursive=false
```

# GeoObject UIDs
Get list of valid UIDs for use in creating new GeoObjec The Common Geo-Registry will only accept newly created GeoObjects with a UID that was issued from the Common GeoRegistry.

| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /geoobjectuids  |  GET  |  <ul><li>numberOfUids=:numberOfUids</li> </ul>  |  Get list of valid UIDs.  |

### Example
```
www.domain.com/geoobjectuids?numberOfUids=20
```

# GeoObject Types
GeoOjectType objects that define the given list of types.

| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /geoobjecttypes  |  GET  |  <ul><li>types=:string[]</li> </ul>  |  Get list of valid GeoObject types.  |

### Example
```
www.domain.com/geoobjecttypes?types=type1,type2,type3
```
