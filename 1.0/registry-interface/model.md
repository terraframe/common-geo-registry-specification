# Location Model Definitions

### GeoObject Model
The location model defines a location object that represents any location in the Common Geo-Registry.

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
    type : string<GeoObjectType>
  }
}

```

### Multi-Location Model
The multi-location model defines an object that contains one or more locations. 

```
{
  locations : array<Location Model>;
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

  
  

## Attribute Types

### Term Attribute
```
{
   name : string,
   label : string,
   terms : {
     name : string,
     label : string
   }
}
```

### Numeric Attribute
```
{
   name : string,
   label : string
}
```
