Details about this project and the requirement goals driving this project can be found [here](https://docs.google.com/document/d/1aJFSVTeAYszU3c2170jvHJlsku6_4HMn6IAlZ2YDtCQ/edit?usp=sharing).

## Overview

The common geo-registry specification seeks to define the API and data specification for communication between the common geo-registry and other systems such as the geospatial widget. There are three primary interface layers that are the subjects of this specification. 
1. RESTful Geo-Object Server Specification to/from RESTful Geo-Object Mobile Interface
2. RESTful Geo-Object Mobile Interface to/from Mobile Host Application
4. Mobile Host Application to/from Geospatial Widget SDK

![High Level Architecture](https://github.com/terraframe/common-geo-registry-specification/blob/master/resources/high-level-design-v1.png)

## Supported Geometry Types
The Common Geo-Registry will support a sub-set of the geometry types that the [GeoJSON specification](https://tools.ietf.org/html/rfc7946) supports. There is current support for:
* Point
* Polygon

The Common Geo-Registry will store locations in collections called hierarchyPositionNames that share a position in a hierarchy along with other defining characteristics. These collections are similar to the concept of a geographic layer. Examples of hierarchyPositionNames are:
* Village
* District
* Country
* etc... 

## GeoJSON Requirements
All GeoJSON objects must adhere to the [rfc7946](https://tools.ietf.org/html/rfc7946) specification.
