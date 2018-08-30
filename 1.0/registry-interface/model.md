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

```
{
  locations : array<Location Model>;
} 

```
