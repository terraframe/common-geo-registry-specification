# About
The registry interface defines the standard API interface to an implementation of a server side common geo-registry. This includes two communication APIs and formal data model definitions.

### Communication APIs
1.  Server side Java API. 
2.  HTTP RESTful API. 

### Data Model Definitions
1.  Model defining location objects.
2.  Model defining collections of location objects.

## Supported Geometry Types
The Common Geo-Registry will support a sub-set of the geometry types that the [GeoJSON specification](https://tools.ietf.org/html/rfc7946) supports. There is current support for:
* Point
* Polygon

The Common Geo-Registry will store locations in collections called hierarchyPositionNames that share a position in a hierarchy along with other defining characteristings. These collections are similar to the concept of a geographic layer. Examples of hierarchyPositionNames are:
* Village
* District
* Country
* etc... 

## GeoJSON Requirements
All GeoJSON objects must adhere to the [rfc7946](https://tools.ietf.org/html/rfc7946) specification.

## Change Log
