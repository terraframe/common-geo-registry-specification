# Location Model Definitions

### GeoObject
Defines an object in the Common Geo-Registry.

All properties have a reference to type Attribute so that name and label properties can both be localized.

```
{
  type : string;
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
|uid | a description |


### GeoObjectView
Defines a view object that is constructed by traversing the relationship graph. 

```
{
  name : {
    attributeLabel : string,
    value : string
  },
  uid : {
    attributeLabel : string,
    value : string
  },
  type : {
    attributeLabel : string,
    valueLabel : string,
    value : string
  },
  status : {
    attributeLabel : string,
    valueLabel : string,
    value : string
  }
}
```

### TreeNode
Defines an object in a relationship tree hierarchy. 

```
{
  "geoObject" : GeoObject,
  "children" : TreeNode[]
}
```


# Meta Model Definitions

### GeoObjectType
```
{
  name : string,
  label : string,
  description : string,
  attributes : attributeType[]
}
```  

### Term
```
{
  name : string,
  label : string
}
```

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

### AttributeNumericType
```
{
   name : string,
   label : string,
   type : string
}
```


