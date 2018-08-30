
### /location
| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /location  |  GET  |  <ul><li>id=:id</li> <li>geomType=:geomType</li></ul>  |  Get a location by id.  |

### /locations
| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /locations  |  GET  |  <ul><li>hierarchyPositionName=:hierarchyPositionName</li> <li>geomType=:geomType</li></ul>  |  Get all locations at a specific level in the location heirarchy.  |

### /directchildlocations
| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /directchildlocations  |  GET  |  <ul><li>id=:id</li> <li>geomType=:geomType</li> <li>hierarchyPositionName=:hierarchyPositionName </li></ul>  |  Get all direct child locations of a specific location.  |

### /directparentlocations
| path  |  Method  |  params  | description  |
|---|---|---|---|
|  /directparentlocations  |  GET  |  <ul> <li>id=:id</li> <li>geomType=:geomType</li> <li>hierarchyPositionName=:hierarchyPositionName </li></ul>  |  Get all direct parent locations of a specific location.  |
