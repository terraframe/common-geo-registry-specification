/**
 * Activity displaying a map where user can record routes by clicking on the map
 * G1.2
 * 
 */
public abstract class RecordManualRouteActivity 
                    implements PermissionsListener, MapboxMap.OnMapClickListener, MapboxMap.OnMarkerClickListener {

    @Override
    public void onMapClick(@NonNull LatLng point) {
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
    }
}
