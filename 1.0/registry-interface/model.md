# Location Model Definitions

### GeoObject
Defines an object returned from a request to the Common Geo-Registry.  GeoObjects store data needed for accessing localized values from a metadata abstraction.


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
    ... user defined and additional system defined attributes added to properties list.
  }
}
```
| Property | Description |Possible Values|
|---|---|--|
|type | [GeoJSON standard type property](https://tools.ietf.org/html/rfc7946) |"Feature", "FeatureCollection"|
|geometry | [GeoJSON standard geometry object](https://tools.ietf.org/html/rfc7946) ||
|geometry.type | [GeoJSON standard geometry object type.](https://tools.ietf.org/html/rfc7946) |"Point", "MultiPoint", "LineString","MultiLineString", "Polygon", "MultiPolygon", "GeometryCollection"|
|geometry.coordinates | [GeoJSON standard geometry object coordinates array.](https://tools.ietf.org/html/rfc7946) ||
|properties | [GeoJSON standard properties object containing non-standard properties.](https://tools.ietf.org/html/rfc7946)||
|properties.uid | UID for the object. ||
|properties.name | Name of the object ||
|properties.type | GeoObjectType UID which this object references. | |
|properties.status | Term UID which this object references.  ||


### TreeNode
Defines an object in a relationship tree hierarchy. A TreeNode contains the current GeoObject as well as it's child TreeNodes that provide the ability to traverse down the relationship hierarchy.

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
Defines an object that describes the type of GeoObject that references it. The GeoObjectType stores data containing localized descriptive values and attributes about the object.

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
// TODO: this
```
{
  name : string,
  localizedLabel : string,
  children : Term[]
}
```
| Property | Description |
|---|---|
|name | Name of the term. |
|localizedLabel | Localized Label for the term. |
|children | Array of Term objects that are children to the current term in the hierarchy. |

## Attribute Types
Attributes store information that describes properties of an object. All GeoObjectType objects have a reference to an Attribute type so that name and label properties can both be localized.

### AttributeTermType
Defines an object that contains localized descriptive data as well as references to references to a Term object. 
```
{
   name : string,
   localizedLabel : string,
   type : string,
   term : string<Term>
}
```
| Property | Description | Possible Values |
|---|---|---|
|name | Name of the term. ||
|localizedLabel | Localized label for the term. ||
|type | Type of attribute. |"TERM"|
|term | Term UID which this attribute references. ||

### AttributeNumericType
Defines an object that contains localized descriptive data. 

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
|type | Type of attribute. |"NUMBER"|


