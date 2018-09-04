/**
 * Activity displaying a map with user location and direction
 * G3.2
 * 
 */
public abstract class LocationActivity 
                implements OnMapReadyCallback, LocationEngineListener, PermissionsListener {

    @Override
    public void onMapReady(MapboxMap mapboxMap) {
    }

    private void setCameraPosition(Location location) {
    }
}
