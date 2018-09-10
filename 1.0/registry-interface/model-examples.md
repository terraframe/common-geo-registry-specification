### EXAMPLE - GeoObject

```
{
  "type": "Feature",
  "geometry": {
    "type": "Point",
    "coordinates": [0, 0]
  },
  "properties": {
    "uid": "EXAMPLE ID",
    "name": "EXAMPLE NAME",
    "type" : "EXAMPLE ID",
    "status" : "EXAMPLE ID"
  }
}
```

### EXAMPLE - TreeNode
```
{
  "geoObject" : EXAMPLEOBJECT,
  "hierarchyType" : "EXAMPLE ID",
  "children" : [
    {
      "geoObject" : EXAMPLEOBJECT,
      "hierarchyType" : "EXAMPLE ID",
      "children" : []
    },{
      "geoObject" : EXAMPLEOBJECT,
      "hierarchyType" : "EXAMPLE ID",
      "children" : [
        {
          "geoObject" : EXAMPLEOBJECT,
          "hierarchyType" : "EXAMPLE ID",
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
  "name" : "EXAMPLE NAME",
  "localizedLabel" : "EXAMPLE LABEL",
  "localizedDescription" : "EXAMPLE DESCRIPTION",
  "attributes" : [//TODO: AttributeTypes]
}
```

### EXAMPLE - HierarchyType
```
{
  "name" : "EXAMPLE NAME",
  "localizedLabel" : "EXAMPLE LABEL",
  "localizedDescription" : "EXAMPLE DESCRIPTION",
  "rootGeoObjectTypes" : [//TODO: HierarchyNode]
}
```

### EXAMPLE - HierarchyNode
```
{
  "geoObjectType" : {
    "name" : "EXAMPLE NAME",
    "localizedLabel" : "EXAMPLE LABEL",
    "localizedDescription" : "EXAMPLE DESCRIPTION",
    "attributes" : [//TODO: AttributeTypes]
  }, 
  "children" : [//TODO: HierarchyNode]
}
```

### EXAMPLE - Term
```
{
  "name" : "EXAMPLE NAME",
  "localizedLabel" : "EXAMPLE LABEL",
  children : [// TODO: Term]
}
```

### EXAMPLE - AttributeTermType
```
{
  "name" : "EXAMPLE NAME",
  "localizedLabel" : "EXAMPLE LABEL",
  "type" : "TERM",
  "term" : "EXAMPLE ID"
}
```

### EXAMPLE - AttributeNumericType
```
{
  "name" : "EXAMPLE NAME",
  "localizedLabel" : "EXAMPLE LABEL",
  "type" : "NUMBER"
}
```
