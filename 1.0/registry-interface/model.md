# Location Model Definitions

### GeoObject Model
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
    status : Term
    // user defined and additional system defined attributes added to properties list.
  }
}
```

### GeoObject View
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

### TermType
```
{
  name : string, // referenced from term property in Attribute
  label : string,
  terms : Term[]
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

### Term Attribute
```
{
   name : string,
   label : string,
   type : string,
   term : string<Term> 
}
```

### Numeric Attribute
```
{
   name : string,
   label : string,
   type : string
}
```


