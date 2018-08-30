
# Single Location
Locations can be queried from the common geo-registry by id.

| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /location  |  GET  |  <ul><li>id=:id</li> <li>geomType=:geomType</li></ul>  |  Get a location by id.  |

### Example
```
www.domain.com/location?id=99999999&geomType=point
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
