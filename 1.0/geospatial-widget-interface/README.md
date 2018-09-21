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
    String[] PARCELABLE_KEY_MAPBOX_STYLES};  // Mapbox Styles (https://www.mapbox.com/mapbox-gl-js/style-spec/)
```

The `MapActivity` should allow selection of a geospatial feature and post it as a result. The geospatial feature SHOULD be in `GeoJSON` format.

Example usage:


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

## Helper Functions

The following helper functions will provide additional functionality to manipulate the data.

