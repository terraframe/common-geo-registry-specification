### Location Model
The location model defines a location object that represents any location in the Common Geo-Registry.

```
{
  type : string;
  geometry : {
    type : string,
    coordinates : double[]
  }
  properties : {
    id : string,
    name : string,
    hierarchyPositionName : string,
    hierarchyPosition : integer
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
