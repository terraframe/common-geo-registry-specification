### EXAMPLE - GeoObject

```
{
  "type": "Feature",
  "geometry": {
    "type": "Point",
    "coordinates": [0, 0]
  },
  "properties": {
    "uid": "123",
    "code": "Valley Health",
    "type" : "HEALTHFACILITY",
    "status" : "ACTIVE",
    "localizedDisplayLabel" : "Valley Health Center",
    "facilityType" : "CLINIC", // user defined property exampl
    "numberOfBeds" : 32 // user defined property example
  }
}
```

### EXAMPLE - TreeNode
```
{
  "geoObject" : geoObject_1,
  "hierarchyType" : "LOCATEDIN",
  "children" : [
    {
      "geoObject" : geoObject_2,
      "hierarchyType" : "LOCATEDIN",
      "children" : []
    },{
      "geoObject" : geoObject_3,
      "hierarchyType" : "LOCATEDIN",
      "children" : [
        {
          "geoObject" : geoObject_4,
          "hierarchyType" : "LOCATEDIN",
          "children" : []
        }
      ]
    }
  ]
}
```

### EXAMPLE - GeoObjectType
```
{
  "code" : "HEALTHFACILITY",
  "localizedLabel" : "Health Facility",
  "localizedDescription" : "Location of an organization classified as a health facility by ...",
  "attributes" : [attributeTermType, attributeNumericType, ...]
}
```

### EXAMPLE - HierarchyType
```
{
  "code" : "LOCATEDIN",
  "localizedLabel" : "Located In",
  "localizedDescription" : "Target GeoObjects are located in a parent GeoObject",
  "rootGeoObjectTypes" : [hierarchyNode ...]
}
```

### EXAMPLE - HierarchyNode
```
{
  "geoObjectType" : geoObjectType, 
  "children" : [hierarchyNode ...]
}
```

### EXAMPLE - Term
```
{
  "code" : "FACILITYTYPE",
  "localizedLabel" : "Facility Type",
  children : [term ...]
}
```

### EXAMPLE - AttributeTermType
```
{
  "code" : "FACILITYtYPE",
  "localizedLabel" : "Facility Type",
  "type" : "TERM",
  "term" : "FACILITYTYPE"
}
```

### EXAMPLE - AttributeNumericType
```
{
  "code" : "NUMBEROFBEDS",
  "localizedLabel" : "Number Of Beds",
  "type" : "NUMBER"
}
```

### EXAMPLE - AttributeDateType
```
{
  "code" : "DATEOPENED",
  "localizedLabel" : "Date Opened",
  "type" : "DATE"
}
```
