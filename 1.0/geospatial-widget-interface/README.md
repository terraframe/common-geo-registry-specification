# Geospatial Widget (Kujaku) Specification

## What is a Geospatial Widget?

The Geospatial widget is an Android SDK designed to connect to the georegistry and other common geographical data sources like OSM and OGC servers. It also supports visualisation of geosptial data and inspection. It is designed to integrate into common mobile data collection tools used in global health.  It is expected to support the three elimination use cases including:
- Case Detection, Notification and Investigation
- Focus Investigation
- Routine and Reactive Intervention

The Geospatial widget library provides a map widget and has a map download service for offline support of map layers. It primarily uses the Mapbox SDK to implement its functionalities. The library also provides some helper util functions to support certain operations involving geospatial data.

# Specification

## MapActivity

The Geospatial widget SHOULD provide  a `MapActivity` activity that is used to display a map view given a Mapbox API access token and an array of Mapbox styles url. The `MapActivity` WILL be initialized through an intent request.
The constants below are required:

```java

    String PARCELABLE_KEY_MAPBOX_ACCESS_TOKEN;  // Mapbox API access token
    String[] PARCELABLE_KEY_MAPBOX_STYLES;  // Mapbox Styles (https://www.mapbox.com/mapbox-gl-js/style-spec/)
```

The following is what should be sent in the `PARCELABLE_KEY_MAPBOX_STYLES`:

Index 0 should have either of the following:
- A file path on the local storage eg. `file:///sdcard/MapboxStyles/nairobi-city-view.json`
- A Mapbox style URL eg. `mapbox://styles/ona/ksdk909kkscd9023k`
- A string of the JSON Object of an existing Mapbox Style or adhering to the Mapbox Style Spec

The `MapActivity` should allow selection of a geospatial feature and post it back as a result. The geospatial feature SHOULD be in `GeoJSON` format.

Example usage:

1. Start an activity to show a Mapbox Style
```java
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Constants.PARCELABLE_KEY_MAPBOX_STYLES, new String[]{
                "file:///sdcard/MapboxStyles/nairobi-city-view.json"
        });
        intent.putExtra(Constants.PARCELABLE_KEY_MAPBOX_ACCESS_TOKEN, "sdklcs823k9OIDFSKsd8uwk");

        startActivity(intent);
```


2. Start an activity with data
```java
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Constants.PARCELABLE_KEY_MAPBOX_STYLES, new String[]{
                "file:///sdcard/MapboxStyles/nairobi-city-view.json"
        });
        intent.putExtra(Constants.PARCELABLE_KEY_MAPBOX_ACCESS_TOKEN, "sdklcs823k9OIDFSKsd8uwk");

        startActivity(intent);
```

3. Start an activity expecting callback in case a feature is selected

```java



        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Constants.PARCELABLE_KEY_MAPBOX_STYLES, new String[]{
                mapboxStyleWithKujakuConfigData
        });
        intent.putExtra(Constants.PARCELABLE_KEY_MAPBOX_ACCESS_TOKEN, "sdklcs823k9OIDFSKsd8uwk");

        startActivityForResult(intent, 43);
```

In case the user clicks on a feature, the info-window at the bottom is displayed to show more details on the feature. Clicking on the feature again is considered a `double-click` and this initiates the callback closing the activity. The activity returns a JSON Object accessible on `Intent` parameter of the `onActivityResult(int, int, Intent)` calling-activity method. The geoJSON feature is retrieved from the `String` extra with the key `geojson_feature`

For the `MapActivity` to respond to clicks on a feature, the feature requires to have:
- Specified in the **Kujaku config**
- Properties defined for it
- An `id` as one of the `properties`


## MapboxOfflineDownloaderService

The Geospatial widget SHOULD provide the `MapboxOfflineDownloaderService` service that is used to download map layers for offline use. This service should also support the deletion of the offline map layers and resuming map layer download.
The service will accept the following constants:

- `PARCELABLE_KEY_SERVICE_ACTION` - Required for all
- `PARCELABLE_KEY_NETWORK_STATE` - Required for `SERVICE_ACTION#NETWORK_RESUME`
- `RCELABLE_KEY_SERVICE_ACTION` - Required for all
- `PARCELABLE_KEY_NETWORK_STATE` - Required for `SERVICE_ACTION#NETWORK_RESUME`
- `PARCELABLE_KEY_MAP_UNIQUE_NAME` - Required for `SERVICE_ACTION#DELETE_MAP` & `SERVICE_ACTION#DOWNLOAD_MAP` & `SERVICE_ACTION#STOP_CURRENT_DOWNLOAD`
- `PARCELABLE_KEY_MAPBOX_ACCESS_TOKEN` - Required for `SERVICE_ACTION#DELETE_MAP` & `SERVICE_ACTION#DOWNLOAD_MAP` & `SERVICE_ACTION#STOP_CURRENT_DOWNLOAD`
- `PARCELABLE_KEY_STYLE_URL` - Required for `SERVICE_ACTION#DOWNLOAD_MAP`
- `PARCELABLE_KEY_MAX_ZOOM` - Required for `SERVICE_ACTION#DOWNLOAD_MAP`
- `PARCELABLE_KEY_MIN_ZOOM` - Required for `SERVICE_ACTION#DOWNLOAD_MAP`
- `PARCELABLE_KEY_TOP_LEFT_BOUND` - Required for `SERVICE_ACTION#DOWNLOAD_MAP`
- `PARCELABLE_KEY_BOTTOM_RIGHT_BOUND` - Required for `SERVICE_ACTION#DOWNLOAD_MAP`
- `PARCELABLE_KEY_DELETE_TASK_TYPE` - Required for `SERVICE_ACTION#STOP_CURRENT_DOWNLOAD`

The `MapboxOfflineDownloaderService` SHOULD post updates through a local broadcast with action `INTENT_ACTION_MAP_DOWNLOAD_SERVICE_STATUS_UPDATES`. The updates SHOULD have:

- `KEY_RESULT_STATUS` - which is either `SERVICE_ACTION_RESULT#SUCCESSFUL` or `SERVICE_ACTION_RESULT#FAILED`
- `KEY_RESULT_MESSAGE` - a simple message, for example, the download percentage or task failure message.
- `PARCELABLE_KEY_MAP_UNIQUE_NAME` - the map name.
- `KEY_RESULTS_PARENT_ACTION` - `SERVICE_ACTION` being performed on the map.

The `MapActivity` will request some permissions(during runtime & in the manifest) for it to work. The following are the permissions:

- `android.permission.ACCESS_FINE_LOCATION`- For the location to center to the user's current location
- `android.permission.ACCESS_NETWORK_STATE`
- `android.permission.ACCESS_WIFI_STATE`
- `android.permission.READ_EXTERNAL_STORAGE` - Read cached mapbox styles on the device
- `android.permission.WRITE_EXTERNAL_STORAGE` - Cache mapbox styles on the device for offline use
- `android.permission.INTERNET` - Automatically permitted

## Helper Functions

The following helper functions will provide additional functionality to manipulate the data.

