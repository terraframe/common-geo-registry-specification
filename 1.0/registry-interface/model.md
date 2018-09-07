# Location Model Definitions

### GeoObject
Defines an object in the Common Geo-Registry.

All properties have a reference to type Attribute so that name and label properties can both be localized.

```
{
  type : string,
  geometry : {
    type : string,
    coordinates : double[]
  }
  properties : {
    uid : string,
    name : string,
    type : string<GeoObjectType>, // maps to GeoObjectType name value
    status : string<Term>
    // user defined and additional system defined attributes added to properties list.
  }
}
```
| Property | Description |Possible Values|
|---|---|--|
|type | [GeoJSON standard type property](https://tools.ietf.org/html/rfc7946) |"Feature", "FeatureCollection"|
|geometry | [GeoJSON standard geometry object](https://tools.ietf.org/html/rfc7946) ||
|geometry.type | [GeoJSON standard geometry object type.](https://tools.ietf.org/html/rfc7946) |"Point", "MultiPoint", "LineString","MultiLineString", "Polygon", "MultiPolygon", "GeometryCollection"|
|geometry.coordinates | GeoJSON standard geometry object coordinates array. ||
|properties | [GeoJSON standard properties object containing non-standard properties.](https://tools.ietf.org/html/rfc7946)||
|properties.uid | UID for the object. ||
|properties.name | Name of the object ||
|properties.type | Type of the object represented as a GeoObjectType object | GeoObjectType |
|properties.status | Term UID which this object references.  ||


### TreeNode
Defines an object in a relationship tree hierarchy. 

```
{
  "geoObject" : GeoObject,
  "children" : TreeNode[]
}
```
| Property | Description |Possible Values|
|---|---|--|
|geoObject | A GeoObject object. ||
|children | An array of TreeNode objects. ||


# Meta Model Definitions

### GeoObjectType
```
{
  name : string,
  localizedLabel : string,
  localizedDescription : string,
  attributes : attributeType[]
}
``` 
| Property | Description |Possible Values|
|---|---|---|
|name | Name of the type. ||
|localizedLabel | Localized label for the object. ||
|localizedDescription | Localized description of the object. ||
|attributes | Array of attribute objects.| AttributeNumericType, AttributeTermType |

### Term
```
{
  name : string,
  localizedLabel : string
}
```
| Property | Description |
|---|---|
|name | Name of the term. |
|localizedLabel | Localized Label for the term. |

## Attribute Types

### AttributeTermType
```
{
   name : string,
   label : string,
   type : string,
   term : string<Term>
}
```
| Property | Description | Possible Values |
|---|---|---|
|name | Name of the term. ||
|localizedLabel | Localized label for the term. ||
|type | Type of attribute. |TERM|
|term | Term UID which this attribute references. ||

### AttributeNumericType
```
{
   name : string,
   localizedLabel : string,
   type : string
}
```
| Property | Description | Possible Values |
|---|---|---|
|name | Name of the term. ||
|localizedLabel | Localized label for the term. ||
|type | Type of attribute. |NUMBER|


