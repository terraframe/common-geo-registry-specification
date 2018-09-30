
# Single Location
GeoObjects can be queried to & from the common geo-registry.

| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /getGeoObject  |  GET  |  <ul><li>uid=:uid</li></ul>  |  Get a GeoObject by id.  |
|  /createGeoObject  |  PUT  | <ul><li>geoObject=:geoObject</li></ul>  |  Create a GeoObject.  |
|  /updateGeoObject  |  PUT  | <ul><li>geoObject=:geoObject</li></ul>  |  Update a GeoObject.  |

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

# Multiple Locations 
Multiple locations can be queried from specific levels of the location hierarchy. 

| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /locations  |  GET  |  <ul><li>hierarchyPositionName=:hierarchyPositionName</li> <li>geomType=:geomType</li></ul>  |  Get all locations at a specific level in the location heirarchy.  |

### Example
```
www.domain.com/locations?hierarchyPositionName=village&geomType=point
```

# Locations By Direct Relationship
Locations can be queried that have a direct relationship with a specific location.

| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /directchildlocations  |  GET  |  <ul><li>id=:id</li> <li>geomType=:geomType</li> <li>hierarchyPositionName=:hierarchyPositionName </li></ul>  |  Get all direct child locations of a specific location.  |

### Example
```
www.domain.com/directchildlocations?hierarchyPositionName=village&geomType=point
```

| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /directparentlocations  |  GET  |  <ul> <li>id=:id</li> <li>geomType=:geomType</li> <li>hierarchyPositionName=:hierarchyPositionName </li></ul>  |  Get all direct parent locations of a specific location.  |

### Example
```
www.domain.com/directparentlocations?hierarchyPositionName=village&geomType=point
```
