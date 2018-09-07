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
| Property | Description |
|---|---|
|type | GeoJSON standard type property |
|geometry | GeoJSON standard geometry object |
|properties | GeoJSON standard properties object containing non-standard properties.|
|properties.uid | |
|properties.name | |
|properties.type | |
|properties.status | |


### TreeNode
Defines an object in a relationship tree hierarchy. 

```
{
  "geoObject" : GeoObject,
  "children" : TreeNode[]
}
```
| Property | Description |
|---|---|
|geoObject | A GeoObject object. |
|children | An array of TreeNode objects. |


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
| Property | Description |
|---|---|
|name | Name of the type. |
|localizedLabel | Localized label for the object. |
|localizedDescription | Localized description of the object. |

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


