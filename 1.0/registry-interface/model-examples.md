### EXAMPLE - Single Point location 

```
{
  "type": "Feature",
  "geometry": {
    "type": "Point",
    "coordinates": [0, 0]
  },
  "properties": {
    "id": "EXAMPLE ID"
    "name": "EXAMPLE NAME"
  }
}
```

### EXAMPLE - Single Polygon location
```
{
  "type": "Feature",
  "geometry": {
    "type": "Polygon",
    "coordinates": [
        [
            [100.0, 0.0],
            [101.0, 0.0],
            [101.0, 1.0],
            [100.0, 1.0],
            [100.0, 0.0]
        ]
    ]
  },
  "properties": {
    "id": "EXAMPLE ID"
    "name": "EXAMPLE NAME"
  }
}
```

### EXAMPLE - Multiple locations
```
[
    {
        "type": "Feature",
        "geometry": {
            "type": "Point",
            "coordinates": [0, 0]
        },
        "properties": {
            "id": "EXAMPLE ID"
            "name": "EXAMPLE NAME"
        }
    },
    {
        "type": "Feature",
        "geometry": {
            "type": "Point",
            "coordinates": [0, 0]
        },
        "properties": {
            "id": "EXAMPLE ID"
            "name": "EXAMPLE NAME"
        }
    }
]
```
